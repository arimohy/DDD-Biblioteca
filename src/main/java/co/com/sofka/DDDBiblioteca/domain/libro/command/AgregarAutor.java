package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Nacionalidad;
import co.com.sofka.domain.generic.Command;

public class AgregarAutor extends Command {
    private final LibroId libroId;
    private final AutorId entityId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;

    public AgregarAutor(LibroId libroId, AutorId entityId, Nombre nombre, Nacionalidad nacionalidad) {
        this.libroId = libroId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public AutorId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }
}
