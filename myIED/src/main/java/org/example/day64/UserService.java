package org.example.day64;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserFullName(int userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            return user.getFirstName() + " " + user.getLastName();
        }
        return null;
    }
}
