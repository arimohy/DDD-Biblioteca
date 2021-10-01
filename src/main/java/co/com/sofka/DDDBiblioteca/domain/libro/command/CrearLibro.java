package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Anio;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class CrearLibro extends Command {
    private final AutorId autorId;
    private final LibroId entityId;
    private final Titulo titulo;
    private final Anio anio;

    public CrearLibro(AutorId autorId, LibroId entityId, Titulo titulo, Anio anio) {
        this.autorId = autorId;
        this.entityId = entityId;
        this.titulo = titulo;
        this.anio = anio;
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

    public Anio getAño() {
        return anio;
    }
}
