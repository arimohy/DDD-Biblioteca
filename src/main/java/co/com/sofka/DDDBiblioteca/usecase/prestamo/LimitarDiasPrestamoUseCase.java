package co.com.sofka.DDDBiblioteca.usecase.prestamo;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.Prestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class LimitarDiasPrestamoUseCase extends UseCase<TriggeredEvent<PrestamoCreado>, ResponseEvents> {
    private final String mensaje="El Lector dejo garantia por el prestamo";
    @Override
    public void executeUseCase(TriggeredEvent<PrestamoCreado> prestamoCreadoTriggeredEvent) {
        var event=prestamoCreadoTriggeredEvent.getDomainEvent();
        var prestamo= Prestamo.from(PrestamoId.of(event.aggregateRootId()),this.retrieveEvents());

        if (event.getDiasDePrestamo().value()>=6){
            System.out.println("si llega aqui");
            prestamo.modificarObservacion(mensaje);
            emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
        }
    }
}
