package projects.personal.notes.note.domian;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.personal.notes.users.User;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long noteId;

    private String titulo;

    private String descripcion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_notes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private Set<User> users;

    public Note(String titulo, String descripcion, Set<User> users) {
        this(null, titulo, descripcion, users);
    }
}
