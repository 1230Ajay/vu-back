package com.vu.vu.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.chatroom.ChatRoom;
import com.vu.vu.course.Course;
import com.vu.vu.Institue.Institute;
import com.vu.vu.address.Address;
import com.vu.vu.fee.Fee;
import com.vu.vu.image.Image;
import com.vu.vu.role.Role;
import com.vu.vu.salary.Salary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uid;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private long phone;

    private String password;
    private Status online;
    private String about;
    private boolean accountlocked;
    private boolean enabled;

    @ManyToMany(fetch = EAGER)
    private List<Role> roles;


    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;


    @LastModifiedDate
    @Column(insertable = false)
    private  LocalDateTime lastModifiedDate;


//    @JsonIgnore
//    @OneToOne
//    private Image avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> addresses;

    @JsonIgnore
    @OneToOne(mappedBy = "manager")
    private Institute institute;


    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Institute> student_in_institutes;

    @JsonIgnore
    @ManyToMany(mappedBy = "tutors")
    private List<Institute> tutor_in_institutes;


    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Course> course;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Fee> fee;

    @JsonIgnore
    @OneToMany(mappedBy = "tutor")
    private List<Salary> salaries;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<ChatRoom> chatRooms =new ArrayList<>();


    public User(String uidString) {
        this.uid = UUID.fromString(uidString);
    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming roles are properly initialized in your User object
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }




    public Object getFullName() {
        return firstname+" "+lastname;
    }
}
