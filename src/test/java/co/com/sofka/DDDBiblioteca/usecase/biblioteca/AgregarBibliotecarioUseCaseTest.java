package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.command.AgregarBibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecarioAgregado;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AgregarBibliotecarioUseCaseTest {
    private static final String idbibliotecario = "bibliotecario1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un blibliotecario en un biblioteca")
    void agregarBibliotecarioEnBiblioteca() {
        //arrange
        var command = new AgregarBibliotecario(BibliotecaId.of("xxxxx"),
                new BibliotecarioId(idbibliotecario),
                new Nombre("Yhomira")
        );
        var useCase = new AgregarBibliotecarioUseCase();
        Mockito.when(repository.getEventsBy(idbibliotecario)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idbibliotecario)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventBibliotecarioAgregado = (BibliotecarioAgregado) events.get(0);
        Assertions.assertEquals("Yhomira", eventBibliotecarioAgregado.getNombre().value());
        Mockito.verify(repository).getEventsBy(idbibliotecario);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new BibliotecaCreada(
                        new EstadoDeBiblioteca("Activo")
                )
        );
    }
}