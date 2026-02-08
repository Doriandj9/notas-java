package projects.personal.notes.note;

import projects.personal.notes.note.dtos.NoteDTO;
import projects.personal.notes.note.dtos.NoteRequest;

import java.util.List;

public interface NoteService {

    public List<NoteDTO> getNotes();

    public NoteDTO createNote(NoteRequest dto);

    public NoteDTO updateNote(NoteRequest dto, Long noteId);
}
