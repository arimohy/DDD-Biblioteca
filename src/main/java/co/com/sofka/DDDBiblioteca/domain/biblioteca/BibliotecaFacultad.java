package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaFacultadId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.NombreBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.domain.generic.Entity;

public class BibliotecaFacultad extends Entity<BibliotecaFacultadId> {
    private final NombreBiblioteca nombreBiblioteca;
    private final Facultad facultad;

    public BibliotecaFacultad(BibliotecaFacultadId entityId, NombreBiblioteca nombreBiblioteca, Facultad facultad) {
        super(entityId);
        this.nombreBiblioteca = nombreBiblioteca;
        this.facultad = facultad;
    }

    public NombreBiblioteca biblioteca() {
        return nombreBiblioteca;
    }

    public Facultad facultad() {
        return facultad;
    }
}
