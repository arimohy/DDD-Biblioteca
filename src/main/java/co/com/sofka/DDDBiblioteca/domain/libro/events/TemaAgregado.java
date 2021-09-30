package co.com.sofka.DDDBiblioteca.domain.libro.events;

import co.com.sofka.DDDBiblioteca.domain.libro.values.EjemplarId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaPrincipal;
import co.com.sofka.domain.generic.DomainEvent;

public class TemaAgregado extends DomainEvent {
    private TemaId temaId;
    private TemaPrincipal temaPrincipal;
    public TemaAgregado(TemaId entityId, TemaPrincipal temaPrincipal) {
        super("sofka.libro.temaaregado");
        this.temaId=entityId;
        this.temaPrincipal=temaPrincipal;
    }

    public TemaId getTemaId() {
        return temaId;
    }

    public TemaPrincipal getTemaPrincipal() {
        return temaPrincipal;
    }
}
