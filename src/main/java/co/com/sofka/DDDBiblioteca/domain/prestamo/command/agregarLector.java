package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.LectorId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.domain.generic.Command;

public class agregarLector extends Command {
    private final PrestamoId prestamoId;
    private final LectorId entityId;
    private final Nombre nombre;
    private final Facultad facultad;

    public agregarLector(PrestamoId prestamoId, LectorId entityId, Nombre nombre, Facultad facultad) {
        this.prestamoId = prestamoId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public LectorId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
