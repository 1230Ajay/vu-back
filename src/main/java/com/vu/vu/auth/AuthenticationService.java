package com.vu.vu.auth;


import com.vu.vu.role.RoleRepository;
import com.vu.vu.security.JwtService;
import com.vu.vu.user.Token;
import com.vu.vu.user.TokenRepository;
import com.vu.vu.user.User;
import com.vu.vu.user.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                // todo - better exception handling
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));
        var user = new User();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAccountlocked(false);
        user.setEnabled(false);
        user.setRoles(List.of(userRole));
        userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {


        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );



        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("name", user.getFullName());
        claims.put("uid",user.getUid());
//        claims.put("avatar",user.getAvatar());

        System.out.println("calims setteled");

        var jwtToken = jwtService.generateToken(claims, (User)auth.getPrincipal());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }




}
