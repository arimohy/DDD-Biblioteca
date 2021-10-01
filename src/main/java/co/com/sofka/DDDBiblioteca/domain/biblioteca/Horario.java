package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioFin;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioInicio;
import co.com.sofka.domain.generic.Entity;


public class Horario extends Entity<HorarioId> {
    private final HorarioInicio horarioInicio;
    private final HorarioFin horarioFin;
    public Horario(HorarioId entityId,HorarioInicio horarioInicio,HorarioFin horarioFin) {
        super(entityId);
        this.horarioInicio=horarioInicio;
        this.horarioFin=horarioFin;

    }

    public HorarioInicio horarioInicio() {
        return horarioInicio;
    }

    public HorarioFin horarioFin() {
        return horarioFin;
    }
}
