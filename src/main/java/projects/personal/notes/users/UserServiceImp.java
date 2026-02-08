package projects.personal.notes.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.personal.notes.users.dtos.UserDTO;
import projects.personal.notes.users.dtos.UserRequest;
import projects.personal.notes.users.mappers.UserMapper;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserRequest dto) {
        User user = new User(dto.username(), dto.username(), dto.password());
        userRepository.save(user);

        return userMapper.userToUserDTO(user);
    }
}
