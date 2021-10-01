package co.com.sofka.DDDBiblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class PrestamoId extends Identity {
    public PrestamoId(){

    }
    private  PrestamoId(String id){
        super(id);
    }
    public static PrestamoId of(String id){
        return new PrestamoId(id);
    }
}
