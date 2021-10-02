package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Biblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.CrearBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.libro.Libro;
import co.com.sofka.DDDBiblioteca.domain.libro.command.CrearLibro;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearLibroUseCase extends UseCase<RequestCommand<CrearLibro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearLibro> crearLibroRequestCommand) {
        var command=crearLibroRequestCommand.getCommand();

        var libro=new Libro(
                command.getEntityId(),
                command.getTitulo(),
                command.getAnio()
        );

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
