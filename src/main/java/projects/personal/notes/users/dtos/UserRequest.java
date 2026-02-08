package projects.personal.notes.users.dtos;

public record UserRequest(
        String name,
        String username,
        String password
) {
}
