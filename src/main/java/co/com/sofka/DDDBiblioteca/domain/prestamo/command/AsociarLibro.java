package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.domain.generic.Command;

public class AsociarLibro extends Command {
    LibroId libroId;

    public AsociarLibro(LibroId libroId) {
        this.libroId = libroId;
    }

    public LibroId getLibroId() {
        return libroId;
    }
}
