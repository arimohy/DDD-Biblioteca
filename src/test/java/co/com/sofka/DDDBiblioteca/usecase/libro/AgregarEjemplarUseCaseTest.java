package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarAutor;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarEjemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.events.AutorAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.EjemplarAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.*;
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
class AgregarEjemplarUseCaseTest {
    private static final String idejemplar = "ejemplar1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un ejemplar en un libro")
    void agregarejemplarEnlibro() {
        //arrange
        var command = new AgregarEjemplar(LibroId.of("lllll"),
                new EjemplarId(idejemplar),
                new Estado("buen estado"),
                new Ubicacion("cerca")
        );
        var useCase = new AgregarEjemplarUseCase();
        Mockito.when(repository.getEventsBy(idejemplar)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idejemplar)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventEjemplarAgregado = (EjemplarAgregado) events.get(0);
        Assertions.assertEquals("buen estado", eventEjemplarAgregado.getEstado().value());
        Assertions.assertEquals("cerca", eventEjemplarAgregado.getUbicacion().value());
        Mockito.verify(repository).getEventsBy(idejemplar);
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new LibroCreado(
                        new Titulo("El librito"),
                        new Anio("2000")
                )
        );
    }
}