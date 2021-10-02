package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.MensajeEnviado;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class EnviarCorreoUseCase extends UseCase<TriggeredEvent<MensajeEnviado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<MensajeEnviado> mensajeEnviadoTriggeredEvent) {
        var event=mensajeEnviadoTriggeredEvent.getDomainEvent();
        var service=this.getService(EnvioDeCorreoService.class).orElseThrow();
        var estabien=service.enviarCorreo("arimohy@gmail.com","notificacion",event.getMensaje());
        if(!estabien){
            emit().onError(new BusinessException(
                    event.aggregateRootId(),
                    "No se pudo enviar el correo"
            ));
        }
    }
}
