package co.com.sofka.DDDBiblioteca.usecase.libro;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarAutor;
import co.com.sofka.DDDBiblioteca.domain.libro.events.AutorAgregado;
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
class AgregarAutorUseCaseTest {
    private static final String idautor = "autor1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un autor en un libro")
    void agregarautorEnlibro() {
        //arrange
        var command = new AgregarAutor(LibroId.of("lllll"),
                new AutorId(idautor),
                new Nombre("Yhomira"),
                new Nacionalidad("peruana")
        );
        var useCase = new AgregarAutorUseCase();
        Mockito.when(repository.getEventsBy(idautor)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idautor)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventLectorAgregado = (AutorAgregado) events.get(0);
        Assertions.assertEquals("Yhomira", eventLectorAgregado.getNombre().value());
        Assertions.assertEquals("peruana", eventLectorAgregado.getNacionalidad().value());
        Mockito.verify(repository).getEventsBy(idautor);
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