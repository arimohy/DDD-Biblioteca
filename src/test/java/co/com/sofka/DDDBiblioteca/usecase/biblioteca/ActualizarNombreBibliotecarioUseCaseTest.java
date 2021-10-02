package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.ActualizarNombreBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.NombreDeBibliotecarioActualizado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
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

@ExtendWith(MockitoExtension.class)
class ActualizarNombreBibliotecarioUseCaseTest {
    private static final String idbibliotecario = "bibliotecario1";
    private static final String idbiblioteca = "biblioteca1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un blibliotecario en un biblioteca")
    void agregarBibliotecarioEnBiblioteca() {
        //arrange
        var command = new ActualizarNombreBibliotecario(
                BibliotecaId.of(idbiblioteca),
                new Nombre("alexandra")
        );
        var useCase = new ActualizarNombreBibliotecarioUseCase();
        Mockito.when(repository.getEventsBy(idbiblioteca)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idbiblioteca)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventClienteActualizado = (NombreDeBibliotecarioActualizado) events.get(0);
        Assertions.assertEquals("alexandra", eventClienteActualizado.getNombre().value());

        Mockito.verify(repository).getEventsBy(idbiblioteca);
    }


    private List<DomainEvent> EventStored() {
        return List.of(
                new BibliotecaCreada(
                        new EstadoDeBiblioteca("Activo")
                ),
                new BibliotecarioAgregado(
                        new BibliotecarioId(idbibliotecario),
                        new Nombre("yhomira")
                )
        );
    }
}