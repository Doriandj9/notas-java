package projects.personal.notes.users;

import projects.personal.notes.users.dtos.UserDTO;
import projects.personal.notes.users.dtos.UserRequest;

public interface UserService {

    public UserDTO createUser(UserRequest dto);

}
