package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Observacion;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.domain.generic.Command;

public class ModificarObservacion extends Command {
    private final PrestamoId prestamoId;
    private final Observacion observacion;

    public ModificarObservacion(PrestamoId prestamoId, Observacion observacion) {
        this.prestamoId = prestamoId;
        this.observacion = observacion;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
