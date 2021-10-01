package co.com.sofka.DDDBiblioteca.usecase;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.CrearBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearBibliotecaUsecaseTest {
    @Test
    void crearBibliotecaEscenarioImplicito(){
        //arrange
        var command=new CrearBiblioteca(
                BibliotecaId.of(("xxxxx")),
                new EstadoDeBiblioteca("Activo"),
                new NombreBiblioteca("BibliotecaYhomira"),
                new Facultad("yhomira"),
                new Nombre("LALA"),
                new HorarioInicio("5am"),
                new HorarioFin("8pm")

        );
        var useCase=new CrearBibliotecaUsecase();
        //act
        var events=UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        Assertions.assertEquals(1,events.size());
        var event =(BibliotecaCreada)events.get(0);
        Assertions.assertEquals("Activo",event.getEstadoDeBiblioteca().value());
        Assertions.assertEquals("BibliotecaYhomira",event.getNombreBiblioteca().value());
        Assertions.assertEquals("yhomira",event.getFacultad().value());
        Assertions.assertEquals("LALA",event.getNombrebibliotecario().value());
        Assertions.assertEquals("5am",event.getHorarioInicio().value());
        Assertions.assertEquals("8pm",event.getHorarioFin().value());
    }
    @Test
    void crearBibliotecaEscenarioExplicito(){

    }

}