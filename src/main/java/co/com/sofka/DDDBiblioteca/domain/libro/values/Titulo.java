package co.com.sofka.DDDBiblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Titulo implements ValueObject<String> {
    private final String value;
    public Titulo(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El titulo no puede estar vacia");
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
        Titulo titulo = (Titulo) o;
        return Objects.equals(value, titulo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
