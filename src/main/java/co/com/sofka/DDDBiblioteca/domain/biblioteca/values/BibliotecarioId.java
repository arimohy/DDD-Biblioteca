package co.com.sofka.DDDBiblioteca.domain.biblioteca.values;

import co.com.sofka.domain.generic.Identity;

public class BibliotecarioId extends Identity {
    public BibliotecarioId(){

    }
    public  BibliotecarioId(String id){
        super(id);
    }
    public static BibliotecarioId of(String id){
        return new BibliotecarioId(id);
    }
}
