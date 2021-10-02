package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.CrearBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.usecase.biblioteca.CrearBibliotecaUsecase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CrearBibliotecaUsecaseTest {
    @Test
    void crearBibliotecaEscenarioExplicito(){
        //arrange
        var command=new CrearBiblioteca(
                BibliotecaId.of(("xxxxx")),
                new EstadoDeBiblioteca("Activo")


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
    }


}