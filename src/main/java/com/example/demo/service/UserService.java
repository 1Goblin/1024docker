package com.example.demo.service;

import com.example.demo.dto.UserCreateRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public UserResponseDto findById(Integer id) {
        User user = userRepository.findById(id);
        return UserResponseDto.from(user);
    }

    public List<UserResponseDto> findByAll() {

        return userRepository.findAll().stream().map(UserResponseDto::from).toList();
    }

    public UserResponseDto save(UserCreateRequestDto entity) {

        User user = userRepository.save(
            new User(null, entity.getName(), entity.getAge(), entity.getJob(),
                entity.getSpecialty(), LocalDateTime.now()));

        return UserResponseDto.from(user);
    }

}
