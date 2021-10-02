package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecaFacultad;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaFacultadAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarBibliotecaFacultadUseCaseTest {
    private static final String idbibliotecafacultad = "bibliotefacultad1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un biblioteca de facultad en un biblioteca")
    void agregarBibliotecaFacultadEnBiblioteca() {
        //arrange
        var command = new AgregarBibliotecaFacultad(BibliotecaId.of("xxxxx"),
                new BibliotecaFacultadId(idbibliotecafacultad),
                new NombreBiblioteca("bibiotecafacultad"),
                new Facultad("ingenieria")
        );
        var useCase = new AgregarBibliotecaFacultadUseCase();
        Mockito.when(repository.getEventsBy(idbibliotecafacultad)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idbibliotecafacultad)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventBibliotecaFacultadAgregado = (BibliotecaFacultadAgregado) events.get(0);
        Assertions.assertEquals("bibiotecafacultad", eventBibliotecaFacultadAgregado.getNombreBiblioteca().value());
        Assertions.assertEquals("ingenieria", eventBibliotecaFacultadAgregado.getFacultad().value());
        Mockito.verify(repository).getEventsBy(idbibliotecafacultad);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new BibliotecaCreada(
                        new EstadoDeBiblioteca("Activo")
                )
        );
    }
}