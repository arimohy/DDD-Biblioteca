package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.domain.generic.Command;

public class AsociarLibro extends Command {
    private final PrestamoId prestamoId;
    private final LibroId libroId;

    public AsociarLibro(PrestamoId prestamoId, LibroId libroId) {
        this.prestamoId = prestamoId;
        this.libroId = libroId;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public LibroId getLibroId() {
        return libroId;
    }
}
