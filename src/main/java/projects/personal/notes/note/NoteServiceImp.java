package projects.personal.notes.note;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.personal.notes.note.domian.Note;
import projects.personal.notes.note.dtos.NoteDTO;
import projects.personal.notes.note.dtos.NoteRequest;
import projects.personal.notes.note.mappers.NoteMapper;
import projects.personal.notes.users.User;
import projects.personal.notes.users.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImp implements NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final UserRepository userRepository;
    @Override
    public List<NoteDTO> getNotes() {

        return noteRepository.findAll().stream().map(noteMapper::NoteToDTO).collect(Collectors.toList());
    }

    @Override
    public NoteDTO createNote(NoteRequest dto) {
        Set<User> users = dto.usernames().stream().map(username -> userRepository.findByUsername(username)
                .orElseThrow( () ->  new EntityNotFoundException("Username " + username + " not found!"))).collect(Collectors.toSet());
        Note  note =  new Note(dto.titulo(), dto.descripcion(),  users);
        noteRepository.save(note);
        return noteMapper.NoteToDTO(note);
    }

    @Override
    public NoteDTO updateNote(NoteRequest dto,  Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new EntityNotFoundException("Note not found"));

        note.setTitulo(dto.titulo());
        note.setDescripcion(dto.descripcion());
        noteRepository.save(note);
        return noteMapper.NoteToDTO(note);
    }
}
