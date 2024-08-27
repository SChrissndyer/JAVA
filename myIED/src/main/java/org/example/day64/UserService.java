package org.example.day64;

public class UserService {

    private UserRepository userRepository;
    private UserRepository userRepository2;

    public UserService(UserRepository userRepository, UserRepository userRepository2) {
        this.userRepository = userRepository;
        this.userRepository2=userRepository2;
    }

    public String getUserFullName(int userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            return user.getFirstName() + " " + user.getLastName();
        }
        return null;
    }
}
