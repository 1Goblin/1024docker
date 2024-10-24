package com.example.demo.repository;

import com.example.demo.model.User;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IRepository<Integer, User> {

    private static final Map<Integer, User> users;

    static {
        users = new HashMap<>();
        users.put(1,
            new User(1, "goblin", 17, "student", "Backend", LocalDateTime.now().plusMinutes(10)));
        users.put(2,
            new User(2, "boblin", 11, "teacher", "Frontend", LocalDateTime.now().plusMinutes(20)));
        users.put(3,
            new User(3, "coblin", 12, "nurse", "DevOps/SRE", LocalDateTime.now().plusMinutes(30)));

    }

    @Override
    public User findById(Integer id) {

        return Optional.ofNullable(users.get(id))
            .orElseThrow(() -> new IllegalArgumentException("조회 가능한 ID가 아닙니다."));
    }

    @Override
    public List<User> findAll() {

        return users.values().stream().toList();
    }

    @Override
    public User save(User entity) {
        int generatedId = users.size() + 1;
        entity.setId(generatedId);

        users.put(generatedId, entity);

        return users.get(generatedId);
    }
}
