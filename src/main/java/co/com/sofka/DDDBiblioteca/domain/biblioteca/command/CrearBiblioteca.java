package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearBiblioteca extends Command {
    private final BibliotecaId entityId;
    private final EstadoDeBiblioteca estadoDeBiblioteca;
    private final NombreBiblioteca nombreBiblioteca;
    private final Facultad facultad;
    private final Nombre nombrebibliotecario;
    private final HorarioInicio horarioInicio;
    private final HorarioFin horarioFin;

    public CrearBiblioteca(BibliotecaId entityId, EstadoDeBiblioteca estadoDeBiblioteca,
                           NombreBiblioteca nombreBiblioteca, Facultad facultad,
                           Nombre nombrebibliotecario, HorarioInicio horarioInicio, HorarioFin horarioFin) {
        this.entityId = entityId;
        this.estadoDeBiblioteca = estadoDeBiblioteca;
        this.nombreBiblioteca = nombreBiblioteca;
        this.facultad = facultad;
        this.nombrebibliotecario = nombrebibliotecario;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public BibliotecaId getEntityId() {
        return entityId;
    }

    public EstadoDeBiblioteca getEstadoDeBiblioteca() {
        return estadoDeBiblioteca;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public Nombre getNombrebibliotecario() {
        return nombrebibliotecario;
    }

    public HorarioInicio getHorarioInicio() {
        return horarioInicio;
    }

    public HorarioFin getHorarioFin() {
        return horarioFin;
    }
}
