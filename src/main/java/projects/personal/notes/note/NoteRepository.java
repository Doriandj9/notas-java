package projects.personal.notes.note;

import org.springframework.data.repository.CrudRepository;
import projects.personal.notes.note.domian.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Long> {

    @Override
    public List<Note> findAll();

    public Optional<Note> findById(Long id);
}
