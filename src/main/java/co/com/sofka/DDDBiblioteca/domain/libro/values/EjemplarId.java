package co.com.sofka.DDDBiblioteca.domain.libro.values;

import co.com.sofka.domain.generic.Identity;

public class EjemplarId extends Identity {
    public EjemplarId(){

    }
    private  EjemplarId(String id){
        super(id);
    }
    public static EjemplarId of(String id){
        return new EjemplarId(id);
    }
}
