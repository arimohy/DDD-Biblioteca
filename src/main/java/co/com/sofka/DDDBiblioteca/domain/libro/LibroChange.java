package co.com.sofka.DDDBiblioteca.domain.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.events.AutorAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.EjemplarAgregado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.LibroCreado;
import co.com.sofka.DDDBiblioteca.domain.libro.events.TemaAgregado;


import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class LibroChange extends EventChange {
    public LibroChange(Libro libro) {
        apply((LibroCreado event)->{
            libro.autores=new HashSet<>();
            libro.temas=new HashSet<>();
            libro.ejemplares=new HashSet<>();
            libro.titulo=event.getTitulo();
            libro.anio=event.getAño();

        });
        apply((TemaAgregado event)->{
            libro.temas.add(new Tema(
                    event.getTemaId(),
                    event.getTemaPrincipal()
            ));
        });
        apply((AutorAgregado event)->{
            libro.autores.add(new Autor(
                    event.getAutorId(),
                    event.getNombre(),
                    event.getNacionalidad()
            ));
        });

        apply((EjemplarAgregado event)->{
            libro.ejemplares.add(new Ejemplar(
                    event.getEjemplarId(),
                    event.getEstado(),
                    event.getUbicacion()
            ));
        });

    }

}
