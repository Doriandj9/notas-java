package projects.personal.notes.note.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import projects.personal.notes.note.domian.Note;
import projects.personal.notes.note.dtos.NoteDTO;
import projects.personal.notes.users.mappers.UserMapper;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NoteMapper {
    private final UserMapper userMapper;

    public NoteDTO NoteToDTO(Note note){

        return new NoteDTO(
                note.getNoteId(),
                note.getTitulo(),
                note.getDescripcion(),
                note.getUsers().stream().map(userMapper::userToUserDTO).collect(Collectors.toSet())
        );
    }

}
