package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.Libro;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarEjemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarTema;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarTemaUseCase extends UseCase<RequestCommand<AgregarTema>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTema> agregarTemaRequestCommand) {
        var command = agregarTemaRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getEntityId().value()));
        libro.agregarTema(command.getEntityId(), command.getTemaPrincipal());
        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
