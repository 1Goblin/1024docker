package com.example.demo.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {

    @Setter
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private String specialty;
    private LocalDateTime createAt;

}
