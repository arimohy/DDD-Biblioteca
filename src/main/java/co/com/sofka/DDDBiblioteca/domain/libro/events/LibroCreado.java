package co.com.sofka.DDDBiblioteca.domain.libro.events;

import co.com.sofka.DDDBiblioteca.domain.libro.Ejemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Año;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Estado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public class LibroCreado extends DomainEvent {
    private final Titulo titulo;
    private final Año año;
    public LibroCreado(Titulo titulo, Año año) {
        super("sofka.libro.librocreado");
        this.titulo=titulo;
        this.año=año;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Año getAño() {
        return año;
    }
}
