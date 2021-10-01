package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaFacultadAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.HorarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.events.AutorAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Nacionalidad;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Biblioteca extends AggregateEvent<BibliotecaId> {
    protected BibliotecaFacultad bibiotecaFacultad;
    protected Bibliotecario bibliotecario;
    protected Horario horario;
    protected EstadoDeBiblioteca estadoDeBiblioteca;


    public Biblioteca(BibliotecaId entityId,EstadoDeBiblioteca estadoDeBiblioteca) {
        super(entityId);
        appendChange(new BibliotecaCreada(estadoDeBiblioteca)).apply();
    }
    private Biblioteca(BibliotecaId entityId){
        super(entityId);
        subscribe(new BibliotecaChange(this));
    }
    public static Biblioteca from(BibliotecaId bibliotecaId, List<DomainEvent> events){
        var biblioteca=new Biblioteca(bibliotecaId);
        events.forEach(biblioteca::applyEvent);
        return biblioteca;
    }
    public void agregarBibliotecaFacultad(BibliotecaFacultadId entityId, NombreBiblioteca nombreBiblioteca, Facultad facultad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreBiblioteca);
        Objects.requireNonNull(facultad);
        appendChange(new BibliotecaFacultadAgregado(entityId,nombreBiblioteca,facultad)).apply();
    }
    public void agregarBibliotecario(BibliotecarioId entityId, Nombre nombre){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        appendChange(new BibliotecarioAgregado(entityId,nombre)).apply();
    }
    public void agregarHorario(HorarioId entityId, HorarioInicio horarioInicio, HorarioFin horarioFin){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(horarioInicio);
        Objects.requireNonNull(horarioFin);
        appendChange(new HorarioAgregado(entityId,horarioInicio,horarioFin)).apply();
    }

}
