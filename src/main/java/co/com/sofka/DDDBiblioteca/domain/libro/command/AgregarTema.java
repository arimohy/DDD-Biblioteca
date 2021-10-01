package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaPrincipal;

public class AgregarTema {
    private final AutorId autorId;
    private final TemaId entityId;
    private final TemaPrincipal temaPrincipal;

    public AgregarTema(AutorId autorId, TemaId entityId, TemaPrincipal temaPrincipal) {
        this.autorId = autorId;
        this.entityId = entityId;
        this.temaPrincipal = temaPrincipal;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public TemaId getEntityId() {
        return entityId;
    }

    public TemaPrincipal getTemaPrincipal() {
        return temaPrincipal;
    }
}
