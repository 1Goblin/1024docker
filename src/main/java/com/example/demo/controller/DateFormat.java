package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
public @interface DateFormat {

}
