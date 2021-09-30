package co.com.sofka.DDDBiblioteca.domain.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.values.EjemplarId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Estado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Ubicacion;
import co.com.sofka.domain.generic.Entity;

public class Ejemplar extends Entity<EjemplarId> {
    private Estado estado;
    private Ubicacion ubicacion;

    public Ejemplar(EjemplarId entityId, Estado estado, Ubicacion ubicacion) {
        super(entityId);
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public Estado estado() {
        return estado;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public void actualizarUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
