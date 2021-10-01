package co.com.sofka.DDDBiblioteca.domain.libro;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.events.AutorAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.EjemplarAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.TemaAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class Libro  extends AggregateEvent<LibroId> {
    protected Set<Autor> autores;
    protected Set<Tema> temas;
    protected Set<Ejemplar> ejemplares;
    protected Titulo titulo;
    protected Anio anio;

    public Libro(LibroId entityId, Titulo titulo, Anio anio) {
        super(entityId);
        appendChange(new LibroCreado(titulo, anio)).apply();
    }
    private Libro(LibroId entityId){
        super(entityId);
        subscribe(new LibroChange(this));
    }
    public static Libro from(LibroId entityId, List<DomainEvent> events){
        var libro=new Libro(entityId);
        events.forEach(libro::applyEvent);
        return libro;
    }
    public void agregarAutor(AutorId entityId, Nombre nombre, Nacionalidad nacionalidad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        appendChange(new AutorAgregado(entityId,nombre,nacionalidad)).apply();
    }
    public void agregarEjemplar(EjemplarId entityId, Estado estado, Ubicacion ubicacion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(estado);
        Objects.requireNonNull(ubicacion);
        appendChange(new EjemplarAgregado(entityId,estado,ubicacion)).apply();
    }
    public void agregarTema(TemaId entityId, TemaPrincipal temaPrincipal){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(temaPrincipal);
        appendChange(new TemaAgregado(entityId,temaPrincipal)).apply();
    }
    public Optional<Autor> getAutorPorId(AutorId entityId){
        return autores()
                .stream()
                .filter(autor->autor.identity().equals(entityId))
                .findFirst();
    }
    public Optional<Tema> getTemaPorId(TemaId entityId){
        return temas()
                .stream()
                .filter(tema->tema.identity().equals(entityId))
                .findFirst();
    }
    public Optional<Ejemplar> getEjemplarPorId(EjemplarId entityId){
        return ejemplares()
                .stream()
                .filter(ejemplar->ejemplar.identity().equals(entityId))
                .findFirst();
    }

    public Set<Autor> autores() {
        return autores;
    }

    public Set<Tema> temas() {
        return temas;
    }

    public Set<Ejemplar> ejemplares() {
        return ejemplares;
    }

    public Titulo titulo() {
        return titulo;
    }

    public Anio año() {
        return anio;
    }
}
