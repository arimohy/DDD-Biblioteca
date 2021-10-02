package co.com.sofka.DDDBiblioteca.domain.biblioteca.values;

import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class HorarioId extends Identity {
    public HorarioId(){

    }
    public HorarioId(String id){
        super(id);
    }
    public static HorarioId of(String id){
        return new HorarioId(id);
    }

}
