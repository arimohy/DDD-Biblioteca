package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.CrearBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.libro.command.CrearLibro;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Anio;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.DDDBiblioteca.usecase.biblioteca.CrearBibliotecaUsecase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearLibroUseCaseTest {
    @Test
    void crearLibroEscenarioExplicito(){
        //arrange
        var command=new CrearLibro(
                LibroId.of(("lllll")),
                new Titulo("El librito"),
                new Anio("2000")


        );
        var useCase=new CrearLibroUseCase();
        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        Assertions.assertEquals(1,events.size());
        var event =(LibroCreado)events.get(0);
        Assertions.assertEquals("El librito",event.getTitulo().value());
        Assertions.assertEquals("2000",event.getAnio().value());

    }

}