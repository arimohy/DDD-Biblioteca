package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Anio;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class CrearLibro extends Command {
    private final LibroId entityId;
    private final Titulo titulo;
    private final Anio anio;

    public CrearLibro(LibroId entityId, Titulo titulo, Anio anio) {
        this.entityId = entityId;
        this.titulo = titulo;
        this.anio = anio;
    }


    public LibroId getEntityId() {
        return entityId;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Anio getAnio() {
        return anio;
    }
}
