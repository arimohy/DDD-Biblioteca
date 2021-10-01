package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Nacionalidad;
import co.com.sofka.domain.generic.Command;

public class AgregarAutor extends Command {
    private final AutorId entityId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;

    public AgregarAutor(AutorId entityId, Nombre nombre, Nacionalidad nacionalidad) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
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
