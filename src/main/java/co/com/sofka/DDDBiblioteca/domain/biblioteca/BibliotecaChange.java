package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.events.*;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaFacultadId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.HorarioId;
import co.com.sofka.domain.generic.EventChange;

public class BibliotecaChange extends EventChange {
    public BibliotecaChange(Biblioteca biblioteca) {
        apply((BibliotecaCreada event)->{
            biblioteca.estadoDeBiblioteca=event.getEstadoDeBiblioteca();
            biblioteca.bibliotecaFacultad =new BibliotecaFacultad(
                    new BibliotecaFacultadId(),
                    event.getNombreBiblioteca(),
                    event.getFacultad());
            biblioteca.bibliotecario=new Bibliotecario(
                    new BibliotecarioId(),
                    event.getNombrebibliotecario());
            biblioteca.horario=new Horario(
                    new HorarioId(),
                    event.getHorarioInicio(),
                    event.getHorarioFin());

        });
        apply((BibliotecaFacultadAgregado event)->{
            biblioteca.bibliotecaFacultad =new BibliotecaFacultad(
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
        apply((EstadoDeBibliotecaActualizada event)->{
            biblioteca.estadoDeBiblioteca=event.getEstadoDeBiblioteca();
        });
        apply((NombreDeBibliotecarioActualizado event)->{
            biblioteca.bibliotecario.actualizarNombre(event.getNombre());
        });
    }
}
