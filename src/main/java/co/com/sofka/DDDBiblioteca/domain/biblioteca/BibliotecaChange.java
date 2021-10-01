package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaCreada;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecaFacultadAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.BibliotecarioAgregado;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.HorarioAgregado;
import co.com.sofka.domain.generic.EventChange;

public class BibliotecaChange extends EventChange {
    public BibliotecaChange(Biblioteca biblioteca) {
        apply((BibliotecaCreada event)->{
            biblioteca.estadoDeBiblioteca=event.getEstadoDeBiblioteca();

        });
        apply((BibliotecaFacultadAgregado event)->{
            biblioteca.bibiotecaFacultad=new BibliotecaFacultad(
                    event.getBibliotecaFacultadId(),
                    event.getNombreBiblioteca(),
                    event.getFacultad()
            );
        });
        apply((BibliotecarioAgregado event)->{
            biblioteca.bibliotecario=new Bibliotecario(
                    event.getBibliotecarioId(),
                    event.getNombre()
            );
        });
        apply((HorarioAgregado event)->{
            biblioteca.horario=new Horario(
                    event.getHorarioId(),
                    event.getHorarioInicio(),
                    event.getHorarioFin()
            );
        });
    }
}
