package co.com.sofka.DDDBiblioteca.usecase.prestamo;


import co.com.sofka.DDDBiblioteca.domain.libro.Libro;
import co.com.sofka.DDDBiblioteca.domain.prestamo.Prestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.command.CrearPrestamo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPrestamoUseCase extends UseCase<RequestCommand<CrearPrestamo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPrestamo> crearPrestamoRequestCommand) {
        var command=crearPrestamoRequestCommand.getCommand();

        var prestamo=new Prestamo(
                command.getEntityId(),
                command.getBibliotecaId(),
                command.getLibroId(),
                command.getFecha(),
                command.getObservacion(),
                command.getDiasDePrestamo(),
                command.getNombre(),
                command.getFacultad()
        );

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
