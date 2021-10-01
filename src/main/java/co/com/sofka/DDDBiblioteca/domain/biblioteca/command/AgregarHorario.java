package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioFin;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioInicio;
import co.com.sofka.domain.generic.Command;

public class AgregarHorario extends Command {
    private final BibliotecaId bibliotecaId;
    private final HorarioId entityId;
    private final HorarioInicio horarioInicio;
    private final HorarioFin horarioFin;

    public AgregarHorario(BibliotecaId bibliotecaId,HorarioId entityId, HorarioInicio horarioInicio, HorarioFin horarioFin) {
        this.bibliotecaId=bibliotecaId;
        this.entityId = entityId;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }

    public HorarioId getEntityId() {
        return entityId;
    }

    public HorarioInicio getHorarioInicio() {
        return horarioInicio;
    }

    public HorarioFin getHorarioFin() {
        return horarioFin;
    }
}
