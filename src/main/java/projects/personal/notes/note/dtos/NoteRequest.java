package projects.personal.notes.note.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record NoteRequest(
        @NotBlank @NotNull
        String titulo,
        @NotBlank(message = "No puede ser vacio") @NotNull(message = "El Campo [descripcion] es obligatorio")
        String descripcion,
        @NotNull @NotEmpty
        List<String> usernames
) {
}
