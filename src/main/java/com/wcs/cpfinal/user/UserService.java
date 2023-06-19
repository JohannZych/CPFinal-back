package com.wcs.cpfinal.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {

        return this.userRepository.findAll();
    }

    public Optional<User> getById(Long id) {

        return this.userRepository.findById(id);
    }

    public User add(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email déjà présent !");
        }
        return this.userRepository.save(user);
    }


    public User update(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setPassword(user.getPassword());
//        existingUser.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
