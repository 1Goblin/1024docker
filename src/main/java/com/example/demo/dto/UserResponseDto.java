package com.example.demo.dto;

import com.example.demo.controller.DateFormat;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"UserName", "UserAge"})
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
public class UserResponseDto {


    private Integer id;
    @JsonProperty("UserName")
    private String name;
    @JsonProperty("UserAge")
    private Integer age;
    @JsonIgnore
    private String job;
    @JsonIgnore
    private String specialty;
    @DateFormat
    private LocalDateTime createAt;


    public static UserResponseDto from(User entity) {
        return new UserResponseDto(
            entity.getId(),
            entity.getName(),
            entity.getAge(),
            entity.getJob(),
            entity.getSpecialty(),
            entity.getCreateAt()
        );
    }


}
