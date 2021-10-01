package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Año;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class CrearLibro extends Command {
    private final AutorId autorId;
    private final LibroId entityId;
    private final Titulo titulo;
    private final Año año;

    public CrearLibro(AutorId autorId, LibroId entityId, Titulo titulo, Año año) {
        this.autorId = autorId;
        this.entityId = entityId;
        this.titulo = titulo;
        this.año = año;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public LibroId getEntityId() {
        return entityId;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Año getAño() {
        return año;
    }
}
