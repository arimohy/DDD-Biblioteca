package co.com.sofka.DDDBiblioteca.usecase.biblioteca;


import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.MensajeEnviado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AlertaPorEstadoInacticoDeBibliotecaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void alertarPorMensaje(){
        var aggregateId="xxx-xxx";
        //arrange
        var event =new BibliotecaCreada(
                new EstadoDeBiblioteca("Inactivo")
        );
        event.setAggregateRootId(aggregateId);
        var useCase=new AlertaPorEstadoInacticoDeBibliotecaUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act
        var events =UseCaseHandler.getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var mensajeEnviado=(MensajeEnviado)events.get(0);
        Assertions.assertEquals("La biblioteca esta INACTIVA",mensajeEnviado.getMensaje());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {
        var event =new BibliotecaCreada(
                new EstadoDeBiblioteca("Inactivo")
        );
        return  List.of(event);
    }
}