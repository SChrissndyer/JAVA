package org.example.day77;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class User {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User(Name: " + this.name + ", Email: " + this.email + ")";
    }
}

