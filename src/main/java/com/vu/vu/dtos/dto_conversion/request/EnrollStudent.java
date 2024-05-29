package com.vu.vu.dtos.dto_conversion.request;

import lombok.Data;

import java.util.UUID;


@Data
public class EnrollStudent {
private UUID student;
private UUID course;
}
