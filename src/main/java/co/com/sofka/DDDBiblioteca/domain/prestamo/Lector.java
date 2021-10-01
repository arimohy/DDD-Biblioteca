package co.com.sofka.DDDBiblioteca.domain.prestamo;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.LectorId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class Lector extends Entity<LectorId> {
    private Nombre nombre;
    private Facultad facultad;


    public Lector(LectorId entityId,Nombre nombre,Facultad facultad) {
        super(entityId);
        this.nombre=nombre;
        this.facultad=facultad;

    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Facultad facultad() {
        return facultad;
    }

    public void actualizarFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}
