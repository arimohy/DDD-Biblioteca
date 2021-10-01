package co.com.sofka.DDDBiblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;
import java.util.Objects;

public class Fecha implements ValueObject<String> {
    private final String value;
    public Fecha(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la fecha  no puede estar vacia");
        }
    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
