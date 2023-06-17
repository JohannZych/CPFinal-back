package com.wcs.cpfinal.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    private List<User> getAll() {

        return userService.getAll();
    }

    @GetMapping("{id}")
    private Optional<User> getById(@PathVariable("id") Long id) {

        return userService.getById(id);
    }

    @PostMapping("/add")
    private User add(@RequestBody User user) {

        return userService.add(user);
    }

    @PutMapping("/update/{id}")
    private User update(@PathVariable("id") Long id, @RequestBody User user) {

        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") Long id) {

        userService.delete(id);
    }

}
