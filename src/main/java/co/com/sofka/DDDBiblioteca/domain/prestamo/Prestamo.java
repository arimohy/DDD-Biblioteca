package co.com.sofka.DDDBiblioteca.domain.prestamo;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.ObservacionModificada;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.BibliotecaAsociada;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.LectorAgregado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.LibroAsociado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Prestamo extends AggregateEvent<PrestamoId> {
    protected Lector lector;
    protected BibliotecaId bibliotecaId;
    protected LibroId libroId;
    protected Fecha fecha;
    protected Observacion observacion;
    protected DiasDePrestamo diasDePrestamo;

    public Prestamo(PrestamoId entityId, BibliotecaId bibliotecaId, LibroId libroId, Fecha fecha,
                    Observacion observacion, DiasDePrestamo diasDePrestamo, Nombre nombre, Facultad facultad) {
        super(entityId);
        appendChange(new PrestamoCreado(entityId,bibliotecaId,libroId,fecha,observacion,diasDePrestamo,
                nombre,facultad)).apply();
    }
    private Prestamo(PrestamoId entityId){
        super(entityId);
        subscribe(new PrestamoChange(this));
    }
    public static Prestamo from(PrestamoId entityId, List<DomainEvent> events){
        var prestamo=new Prestamo(entityId);
        events.forEach(prestamo::applyEvent);
        return prestamo;
    }
    public void agregarLector(LectorId entityId, Nombre nombre, Facultad facultad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(facultad);
        appendChange(new LectorAgregado(entityId,nombre,facultad)).apply();
    }
    public void AsociarBiblioteca(BibliotecaId bibliotecaId){
        appendChange(new BibliotecaAsociada(bibliotecaId)).apply();
    }
    public void AsociarLibro(LibroId libroId){
        appendChange(new LibroAsociado(libroId)).apply();
    }
    public void modificarObservacion(String mensaje) {
        appendChange(new ObservacionModificada(mensaje)).apply();
    }
    public Lector lector() {
        return lector;
    }

    public BibliotecaId bibliotecaId() {
        return bibliotecaId;
    }

    public LibroId libroId() {
        return libroId;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Observacion observacion() {
        return observacion;
    }

    public DiasDePrestamo diasDePrestamo() {
        return diasDePrestamo;
    }


}
