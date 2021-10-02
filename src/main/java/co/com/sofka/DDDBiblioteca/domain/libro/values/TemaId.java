package co.com.sofka.DDDBiblioteca.domain.libro.values;

import co.com.sofka.DDDBiblioteca.domain.prestamo.values.LectorId;
import co.com.sofka.domain.generic.Identity;

public class TemaId extends Identity {
    public TemaId(){

    }
    public TemaId(String id){
        super(id);
    }
    public static TemaId of(String id){
        return new TemaId(id);
    }
}
