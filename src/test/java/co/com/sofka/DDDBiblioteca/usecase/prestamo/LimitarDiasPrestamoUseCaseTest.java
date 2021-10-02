package co.com.sofka.DDDBiblioteca.usecase.prestamo;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.ObservacionModificada;
import co.com.sofka.DDDBiblioteca.domain.prestamo.events.PrestamoCreado;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.DiasDePrestamo;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Fecha;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Observacion;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
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
class LimitarDiasPrestamoUseCaseTest {
    private static final String idprestamo = "prestamo1";
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("test prestamo para modificacion de observacion")
    void agregarBibliotecarioEnBiblioteca() {
        var aggregateId="ppppp";
        //arrange
        var event =new PrestamoCreado(
                PrestamoId.of(aggregateId),
                BibliotecaId.of("bbbbb"),
                LibroId.of("lllll"),
                new Fecha("12/50/2020"),
                new Observacion("todobem"),
                new DiasDePrestamo(6),
                new Nombre("nombre"),
                new Facultad("facultad")
        );
        event.setAggregateRootId(aggregateId);
        var useCase=new LimitarDiasPrestamoUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act
        var events =UseCaseHandler.getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var observacion=(ObservacionModificada)events.get(0);
        Assertions.assertEquals("El Lector dejo garantia por el prestamo",observacion.getObservacion().value());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {
        var event =new PrestamoCreado(
                PrestamoId.of("ppppp"),
                BibliotecaId.of("bbbbb"),
                LibroId.of("lllll"),
                new Fecha("12/50/2020"),
                new Observacion("todobem"),
                new DiasDePrestamo(6),
                new Nombre("nombre"),
                new Facultad("facultad")
        );
        return  List.of(event);
    }
}