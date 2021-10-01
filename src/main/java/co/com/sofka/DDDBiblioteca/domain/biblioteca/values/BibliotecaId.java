package co.com.sofka.DDDBiblioteca.domain.biblioteca.values;

import co.com.sofka.domain.generic.Identity;

public class BibliotecaId extends Identity {
    public BibliotecaId(){

    }
    private  BibliotecaId(String id){
        super(id);
    }
    public static BibliotecaId of(String id){
        return new BibliotecaId(id);
    }
}
