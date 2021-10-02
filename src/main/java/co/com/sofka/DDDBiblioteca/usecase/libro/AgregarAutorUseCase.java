package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.Libro;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarAutor;
import co.com.sofka.DDDBiblioteca.domain.prestamo.Prestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.command.AgregarLector;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarAutorUseCase extends UseCase<RequestCommand<AgregarAutor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAutor> agregarAutorRequestCommand) {
        var command = agregarAutorRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getEntityId().value()));
        libro.agregarAutor(command.getEntityId(), command.getNombre(), command.getNacionalidad());
        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
