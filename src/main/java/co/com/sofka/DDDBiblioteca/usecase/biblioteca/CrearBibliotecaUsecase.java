package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.CrearBiblioteca;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearBibliotecaUsecase extends UseCase<RequestCommand<CrearBiblioteca>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearBiblioteca> crearBibliotecaRequestCommand) {

        var command=crearBibliotecaRequestCommand.getCommand();

        var biblioteca=new Biblioteca(
                command.getEntityId(),
                command.getEstadoDeBiblioteca()
        );

        emit().onResponse(new ResponseEvents(biblioteca.getUncommittedChanges()));
    }
}
