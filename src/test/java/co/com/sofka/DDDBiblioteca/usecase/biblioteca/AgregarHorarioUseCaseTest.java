package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarHorario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.HorarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
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
class AgregarHorarioUseCaseTest {
    private static final String idhorario = "horario1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar horario en un biblioteca")
    void agregarHorarioEnBiblioteca() {
        //arrange
        var command = new AgregarHorario(BibliotecaId.of("xxxxx"),
                new HorarioId(idhorario),
                new HorarioInicio("8am"),
                new HorarioFin("9pm")

        );
        var useCase = new AgregarHorarioUseCase();
        Mockito.when(repository.getEventsBy(idhorario)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idhorario)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventHorarioAgregado = (HorarioAgregado) events.get(0);
        Assertions.assertEquals("8am", eventHorarioAgregado.getHorarioInicio().value());
        Assertions.assertEquals("9pm", eventHorarioAgregado.getHorarioFin().value());
        Mockito.verify(repository).getEventsBy(idhorario);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new BibliotecaCreada(
                        new EstadoDeBiblioteca("Activo")
                )
        );
    }
}