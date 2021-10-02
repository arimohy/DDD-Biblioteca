package co.com.sofka.DDDBiblioteca.usecase.prestamo;

import co.com.sofka.DDDBiblioteca.domain.prestamo.Prestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.command.AgregarLector;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarLectorUseCase extends UseCase<RequestCommand<AgregarLector>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarLector> agregarLectorRequestCommand) {
        var command = agregarLectorRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getEntityId().value()));
        prestamo.agregarLector(command.getEntityId(), command.getNombre(), command.getFacultad());
        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
