package projects.personal.notes.note.dtos;

import projects.personal.notes.users.dtos.UserDTO;

import java.util.Set;

public record NoteDTO(
        Long noteId,
        String titulo,
        String descripcion,
        Set<UserDTO> users
) {
}
