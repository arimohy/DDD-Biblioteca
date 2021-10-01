package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioFin;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioInicio;
import co.com.sofka.domain.generic.DomainEvent;

public class HorarioAgregado extends DomainEvent {
    private final HorarioId horarioId;
    private final HorarioInicio horarioInicio;
    private final HorarioFin horarioFin;
    public HorarioAgregado(HorarioId entityId, HorarioInicio horarioInicio, HorarioFin horarioFin) {
        super("sofka.bibliotecario.horarioagregado");
        this.horarioId=entityId;
        this.horarioInicio=horarioInicio;
        this.horarioFin=horarioFin;
    }

    public HorarioId getHorarioId() {
        return horarioId;
    }

    public HorarioInicio getHorarioInicio() {
        return horarioInicio;
    }

    public HorarioFin getHorarioFin() {
        return horarioFin;
    }
}
