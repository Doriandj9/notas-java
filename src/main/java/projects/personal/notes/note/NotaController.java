package projects.personal.notes.note;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.personal.notes.note.dtos.NoteDTO;
import projects.personal.notes.note.dtos.NoteRequest;

import java.util.List;

@RestController
@RequestMapping("notes")
@RequiredArgsConstructor
public class NotaController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<NoteDTO>> getNotesAll(){
        return ResponseEntity.ok(noteService.getNotes());
    }

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@RequestBody @Valid NoteRequest dto) {
        return ResponseEntity.ok(noteService.createNote(dto));
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long noteId, @RequestBody @Valid NoteRequest dto) {
        return  ResponseEntity.ok(noteService.updateNote(dto, noteId));
    }

}
