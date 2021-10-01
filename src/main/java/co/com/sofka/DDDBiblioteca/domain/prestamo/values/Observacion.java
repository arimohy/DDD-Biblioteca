package co.com.sofka.DDDBiblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observacion implements ValueObject <String>{
    private final String value;
    public Observacion(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("la observacion de sala no puede estar vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observacion that = (Observacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
