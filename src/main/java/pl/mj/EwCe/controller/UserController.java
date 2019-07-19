package pl.mj.EwCe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.mj.EwCe.model.User;
import pl.mj.EwCe.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Page<User> getAllUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

//    @GetMapping
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }




    @GetMapping("/{id}")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User do not exist in database"));
    }

//    @PostMapping
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }

}
