package co.com.sofka.DDDBiblioteca.usecase.prestamo;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.command.CrearLibro;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Anio;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.command.CrearPrestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.DiasDePrestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Fecha;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Observacion;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.DDDBiblioteca.usecase.libro.CrearLibroUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPrestamoUseCaseTest {
    @Test
    void crearPrestamoEscenarioExplicito() {
        //arrange
        var command = new CrearPrestamo(
                PrestamoId.of("ppppp"),
                BibliotecaId.of("bbbbb"),
                LibroId.of("lllll"),
                new Fecha("12/50/2020"),
                new Observacion("todobem"),
                new DiasDePrestamo(3),
                new Nombre("nombre"),
                new Facultad("facultad")
        );
        var useCase = new CrearPrestamoUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        Assertions.assertEquals(1, events.size());
        var event = (PrestamoCreado) events.get(0);
        Assertions.assertEquals("12/50/2020", event.getFecha().value());
        Assertions.assertEquals("todobem", event.getObservacion().value());
        Assertions.assertEquals("12/50/2020", event.getFecha().value());
        Assertions.assertEquals(3, event.getDiasDePrestamo().value());
        Assertions.assertEquals("nombre", event.getNombre().value());
        Assertions.assertEquals("facultad", event.getFacultad().value());

    }
}