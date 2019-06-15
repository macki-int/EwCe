package pl.mj.EwCe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mj.EwCe.model.User;
import pl.mj.EwCe.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> get() {
        return userRepository.findAll();
    }

    @PostMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
