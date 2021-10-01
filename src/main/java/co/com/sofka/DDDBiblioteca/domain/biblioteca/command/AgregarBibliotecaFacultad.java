package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaFacultadId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.NombreBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.domain.generic.Command;

public class AgregarBibliotecaFacultad extends Command {
    private final BibliotecaId bibliotecaId;
    private final BibliotecaFacultadId entityId;
    private final NombreBiblioteca nombreBiblioteca;
    private final  Facultad facultad;

    public AgregarBibliotecaFacultad(BibliotecaId bibliotecaId,BibliotecaFacultadId entityId, NombreBiblioteca nombreBiblioteca, Facultad facultad) {
        this.bibliotecaId=bibliotecaId;
        this.entityId = entityId;
        this.nombreBiblioteca = nombreBiblioteca;
        this.facultad = facultad;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }

    public BibliotecaFacultadId getEntityId() {
        return entityId;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
