package co.com.sofka.DDDBiblioteca.domain.prestamo.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.DiasDePrestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Fecha;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Observacion;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PrestamoCreado extends DomainEvent {
    private final PrestamoId prestamoId;
    private final BibliotecaId bibliotecaId;
    private final LibroId libroId;
    private final Fecha fecha;
    private final  Observacion observacion;
    private final DiasDePrestamo diasDePrestamo;
    private final Nombre nombre;
    private final Facultad facultad;

    public PrestamoCreado(PrestamoId entityId, BibliotecaId bibliotecaId, LibroId libroId, Fecha fecha,
                          Observacion observacion, DiasDePrestamo diasDePrestamo, Nombre nombre, Facultad facultad) {
        super("sofka.prestamo.lectorcreado");
        this.prestamoId=entityId;
        this.bibliotecaId=bibliotecaId;
        this.libroId=libroId;
        this.fecha=fecha;
        this.observacion=observacion;
        this.diasDePrestamo=diasDePrestamo;
        this.nombre=nombre;
        this.facultad=facultad;

    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public DiasDePrestamo getDiasDePrestamo() {
        return diasDePrestamo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
