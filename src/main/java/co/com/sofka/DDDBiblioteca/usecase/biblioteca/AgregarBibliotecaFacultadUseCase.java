package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecaFacultad;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarBibliotecaFacultadUseCase extends UseCase<RequestCommand<AgregarBibliotecaFacultad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarBibliotecaFacultad> agregarBibliotecaFacultadRequestCommand) {
        var command = agregarBibliotecaFacultadRequestCommand.getCommand();
        var biblioteca = Biblioteca.from(command.getBibliotecaId(), retrieveEvents(command.getEntityId().value()));
        biblioteca.agregarBibliotecaFacultad(command.getEntityId(), command.getNombreBiblioteca(),command.getFacultad());
        emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
    }
}
