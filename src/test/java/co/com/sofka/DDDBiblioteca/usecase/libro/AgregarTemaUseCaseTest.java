package co.com.sofka.DDDBiblioteca.usecase.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarEjemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.command.AgregarTema;
import co.com.sofka.DDDBiblioteca.domain.libro.events.EjemplarAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.TemaAgregado;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AgregarTemaUseCaseTest {
    private static final String idtema = "tema1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test agregar un tema en un libro")
    void agregarTemaEnlibro() {
        //arrange
        var command = new AgregarTema(LibroId.of("lllll"),
                new TemaId(idtema),
                new TemaPrincipal("los retos")
        );
        var useCase = new AgregarTemaUseCase();
        Mockito.when(repository.getEventsBy(idtema)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idtema)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventTemaAgregado = (TemaAgregado) events.get(0);
        Assertions.assertEquals("los retos", eventTemaAgregado.getTemaPrincipal().value());
        Mockito.verify(repository).getEventsBy(idtema);
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