package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.Ejemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarEjemplar extends Command {
    private final LibroId libroId;
    private final EjemplarId entityId;
    private final Estado estado;
    private final Ubicacion ubicacion;

    public AgregarEjemplar(LibroId libroId,EjemplarId entityId, Estado estado, Ubicacion ubicacion) {
        this.libroId=libroId;
        this.entityId = entityId;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public EjemplarId getEntityId() {
        return entityId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
