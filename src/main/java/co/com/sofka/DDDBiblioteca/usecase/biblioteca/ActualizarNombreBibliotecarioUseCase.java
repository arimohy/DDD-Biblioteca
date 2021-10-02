package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.ActualizarNombreBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarNombreBibliotecarioUseCase extends UseCase<RequestCommand<ActualizarNombreBibliotecario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreBibliotecario> actualizarNombreBibliotecarioRequestCommand) {
        var command = actualizarNombreBibliotecarioRequestCommand.getCommand();
        var biblioteca = Biblioteca.from(command.getBibliotecaId(), retrieveEvents(command.getBibliotecaId().value()));
        biblioteca.actualizarNombreDeBibliotecario(command.getNombre());
        emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
    }
}
