package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarHorario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarHorarioUseCase extends UseCase<RequestCommand<AgregarHorario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarHorario> agregarHorarioRequestCommand) {
        var command = agregarHorarioRequestCommand.getCommand();
        var biblioteca = Biblioteca.from(command.getBibliotecaId(), retrieveEvents(command.getEntityId().value()));
        biblioteca.agregarHorario(command.getEntityId(), command.getHorarioInicio(),command.getHorarioFin());
        emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
    }
}
