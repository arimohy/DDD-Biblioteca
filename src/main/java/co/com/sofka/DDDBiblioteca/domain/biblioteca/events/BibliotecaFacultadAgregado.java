package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaFacultadId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.NombreBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.domain.generic.DomainEvent;

public class BibliotecaFacultadAgregado extends DomainEvent {
    private final BibliotecaFacultadId bibliotecaFacultadId;
    private final NombreBiblioteca nombreBiblioteca;
    private final Facultad facultad;
    public BibliotecaFacultadAgregado(BibliotecaFacultadId entityId, NombreBiblioteca nombreBiblioteca, Facultad facultad) {
        super("sofka.biblioteca.bibliotecafacultadagregado");
        this.bibliotecaFacultadId=entityId;
        this.nombreBiblioteca=nombreBiblioteca;
        this.facultad=facultad;
    }

    public BibliotecaFacultadId getBibliotecaFacultadId() {
        return bibliotecaFacultadId;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
