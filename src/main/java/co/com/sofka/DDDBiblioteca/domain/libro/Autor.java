package co.com.sofka.DDDBiblioteca.domain.libro;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Nacionalidad;
import co.com.sofka.domain.generic.Entity;

public class Autor extends Entity<AutorId> {
    private Nombre nombre;
    private Nacionalidad nacionalidad;

    public Autor(AutorId entityId, Nombre nombre, Nacionalidad nacionalidad) {
        super(entityId);
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
