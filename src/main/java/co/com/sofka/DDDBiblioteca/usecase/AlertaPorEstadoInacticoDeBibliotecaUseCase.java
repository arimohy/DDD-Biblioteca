package co.com.sofka.DDDBiblioteca.usecase;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AlertaPorEstadoInacticoDeBibliotecaUseCase extends UseCase<TriggeredEvent<BibliotecaCreada>, ResponseEvents> {
    private final String mensaje="La biblioteca esta INACTIVA";
    @Override
    public void executeUseCase(TriggeredEvent<BibliotecaCreada> bibliotecaCreadaTriggeredEvent) {
        var event=bibliotecaCreadaTriggeredEvent.getDomainEvent();
        var biblioteca= Biblioteca.from(BibliotecaId.of(event.aggregateRootId()),this.retrieveEvents());


        if (event.getEstadoDeBiblioteca().value().equals("Inactivo")){
            biblioteca.enviarAlerta(mensaje);
            emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
        }
    }
}
