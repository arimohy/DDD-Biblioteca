package co.com.sofka.DDDBiblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class LectorId extends Identity {
    public LectorId(){

    }
    private  LectorId(String id){
        super(id);
    }
    public static LectorId of(String id){
        return new LectorId(id);
    }
}
