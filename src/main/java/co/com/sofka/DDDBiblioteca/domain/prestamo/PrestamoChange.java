package co.com.sofka.DDDBiblioteca.domain.prestamo;

import co.com.sofka.DDDBiblioteca.domain.prestamo.events.BibliotecaAsociada;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.LibroAsociado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.LectorId;
import co.com.sofka.domain.generic.EventChange;

public class PrestamoChange extends EventChange {
    public PrestamoChange(Prestamo prestamo) {
        apply((PrestamoCreado event)->{
            prestamo.diasDePrestamo=event.getDiasDePrestamo();
            prestamo.observacion=event.getObservacion();
            prestamo.fecha=event.getFecha();
            prestamo.lector=new Lector(new LectorId(),event.getNombre(),event.getFacultad());
            prestamo.libroId=event.getLibroId();
            prestamo.bibliotecaId=event.getBibliotecaId();

        });
        apply((LibroAsociado event)-> {
            prestamo.libroId = event.getLibroId();
        });
        apply((BibliotecaAsociada event)-> {
            prestamo.bibliotecaId = event.getBibliotecaId();
        });


    }
}
