package day64Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import org.example.day64.User;
import org.example.day64.UserRepository;
import org.example.day64.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserRepository userRepository2;


    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository,userRepository2);
    }

    @Test
    public void testGetUserFullName() {
        // Arrange
        User user = new User("John", "Doe");
        when(userRepository.findById(anyInt())).thenReturn(user);

        // Act
        String fullName = userService.getUserFullName(1);

        // Assert
        assertEquals("John Doe", fullName);
    }

    @Test
    public void testGetUserFullName_UserNotFound() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(null);

        // Act
        String fullName = userService.getUserFullName(1);

        // Assert
        assertNull(fullName);
    }
}
