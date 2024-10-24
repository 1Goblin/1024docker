package com.example.demo.controller;


import com.example.demo.dto.UserCreateRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("users")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("")
    public String userPage(Model model) {

        List<UserResponseDto> users = userService.findByAll();
        model.addAttribute("users", users);

        return "users/list";
    }

    @GetMapping("/detail")
    public String userDetailPage(@RequestParam Integer id, Model model) {
        UserResponseDto user = userService.findById(id);

        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("job", user.getJob());
        model.addAttribute("specialty", user.getSpecialty());

        return "users/detail";
    }

    @GetMapping("/data")
    public ResponseEntity<UserResponseDto> userDataPage(@RequestParam Integer id) {

        try {
            UserResponseDto user = userService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }

    @PostMapping("")
    public ResponseEntity<UserResponseDto> saveUser(
        @RequestBody @Valid UserCreateRequestDto request) {
        UserResponseDto user = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

}
