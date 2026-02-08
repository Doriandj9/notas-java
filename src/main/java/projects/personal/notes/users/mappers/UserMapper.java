package projects.personal.notes.users.mappers;

import org.springframework.stereotype.Component;
import projects.personal.notes.users.User;
import projects.personal.notes.users.dtos.UserDTO;

@Component
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getName()
        );
    }
}
