package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioFin;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioInicio;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.NombreBiblioteca;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class BibliotecaCreada extends DomainEvent {
    private final EstadoDeBiblioteca estadoDeBiblioteca;
    private final NombreBiblioteca nombreBiblioteca;
    private final Facultad facultad;
    private final Nombre nombrebibliotecario;
    private final HorarioInicio horarioInicio;
    private final HorarioFin horarioFin;
    public BibliotecaCreada(EstadoDeBiblioteca estadoDeBiblioteca, NombreBiblioteca nombreBiblioteca, Facultad facultad,
                            Nombre nombrebibliotecario, HorarioInicio horarioInicio, HorarioFin horarioFin) {
        super("sofka.biblioteca.bibliotecacreada");
        this.estadoDeBiblioteca=estadoDeBiblioteca;
        this.nombreBiblioteca = nombreBiblioteca;
        this.facultad = facultad;
        this.nombrebibliotecario = nombrebibliotecario;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
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
