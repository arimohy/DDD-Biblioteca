package co.com.sofka.DDDBiblioteca.domain.biblioteca.values;

import co.com.sofka.domain.generic.Identity;

public class BibliotecaFacultadId extends Identity {
    public BibliotecaFacultadId(){

    }
    public BibliotecaFacultadId(String id){
        super(id);
    }
    public static BibliotecaFacultadId of(String id){
        return new BibliotecaFacultadId(id);
    }
}
