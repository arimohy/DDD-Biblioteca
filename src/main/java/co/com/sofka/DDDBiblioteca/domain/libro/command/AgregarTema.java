package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaPrincipal;
import co.com.sofka.domain.generic.Command;

public class AgregarTema extends Command {
    private final LibroId libroId;
    private final TemaId entityId;
    private final TemaPrincipal temaPrincipal;

    public AgregarTema(LibroId libroId, TemaId entityId, TemaPrincipal temaPrincipal) {
        this.libroId = libroId;
        this.entityId = entityId;
        this.temaPrincipal = temaPrincipal;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public TemaId getEntityId() {
        return entityId;
    }

    public TemaPrincipal getTemaPrincipal() {
        return temaPrincipal;
    }
}
