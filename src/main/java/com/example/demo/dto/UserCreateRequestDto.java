package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class UserCreateRequestDto {


    private String name;
    @Min(10)
    private Integer age;
    private String job;
    private String specialty = "empty";

}
