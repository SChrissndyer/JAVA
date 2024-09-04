package org.example.day77;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors occurred.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }

    @GetMapping("/public/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to the public API!");
    }

    @GetMapping("/private/secret")
    public ResponseEntity<String> secret() {
        return ResponseEntity.ok("This is a secret message!");
    }
}

