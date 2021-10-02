package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.libro.Libro;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarAutor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarBibliotecarioUseCase extends UseCase<RequestCommand<AgregarBibliotecario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarBibliotecario> agregarBibliotecarioRequestCommand) {
        var command = agregarBibliotecarioRequestCommand.getCommand();
        var biblioteca = Biblioteca.from(command.getBibliotecaId(), retrieveEvents(command.getEntityId().value()));
        biblioteca.agregarBibliotecario(command.getEntityId(), command.getNombre());
        emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
    }
}
