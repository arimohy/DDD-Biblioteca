package co.com.sofka.DDDBiblioteca.domain.generics.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Facultad implements ValueObject<String> {
    private final String value;
    public Facultad(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La facultad no puede estar vacia");
        }
    }
    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facultad facultad = (Facultad) o;
        return Objects.equals(value, facultad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
