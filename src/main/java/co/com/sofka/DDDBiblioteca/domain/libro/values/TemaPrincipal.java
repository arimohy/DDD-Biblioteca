package co.com.sofka.DDDBiblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TemaPrincipal implements ValueObject<String> {
    private final String value;
    public TemaPrincipal(String value){
            this.value= Objects.requireNonNull(value);
            if(this.value.isBlank()){
            throw new IllegalArgumentException("El tema principal no puede estar vacia");
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
        TemaPrincipal that = (TemaPrincipal) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
