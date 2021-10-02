package co.com.sofka.DDDBiblioteca.domain.libro.events;

import co.com.sofka.DDDBiblioteca.domain.libro.values.Anio;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Titulo;
import co.com.sofka.domain.generic.DomainEvent;

public class LibroCreado extends DomainEvent {
    private final Titulo titulo;
    private final Anio anio;
    public LibroCreado(Titulo titulo, Anio anio) {
        super("sofka.libro.librocreado");
        this.titulo=titulo;
        this.anio = anio;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Anio getAnio() {
        return anio;
    }
}
