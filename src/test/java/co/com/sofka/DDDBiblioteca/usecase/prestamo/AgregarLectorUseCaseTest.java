package co.com.sofka.DDDBiblioteca.usecase.prestamo;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.command.AgregarLector;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.LectorAgregado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.*;
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


@ExtendWith(MockitoExtension.class)
class AgregarLectorUseCaseTest {
    private static final String idlector = "lector1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un lector en un prestamo")
    void agregarLectorEnPrestamo() {
        //arrange
        var command = new AgregarLector(PrestamoId.of("ppppp"),
                new LectorId(idlector),
                new Nombre("Yhomira"),
                new Facultad("ingenieria")
        );
        var useCase = new AgregarLectorUseCase();
        Mockito.when(repository.getEventsBy(idlector)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idlector)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventLectorAgregado = (LectorAgregado) events.get(0);
        Assertions.assertEquals("Yhomira", eventLectorAgregado.getNombre().value());
        Assertions.assertEquals("ingenieria", eventLectorAgregado.getFacultad().value());
        Mockito.verify(repository).getEventsBy(idlector);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new PrestamoCreado(
                        PrestamoId.of("ppppp"),
                        BibliotecaId.of("bbbbb"),
                        LibroId.of("lllll"),
                        new Fecha("12/50/2020"),
                        new Observacion("todobem"),
                        new DiasDePrestamo(3),
                        new Nombre("nombre"),
                        new Facultad("facultad")
                )
        );
    }

}