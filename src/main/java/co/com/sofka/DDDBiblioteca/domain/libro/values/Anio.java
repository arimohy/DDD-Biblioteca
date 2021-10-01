package co.com.sofka.DDDBiblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Anio implements ValueObject<String> {
    private final String value;

    public Anio(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El año no puede estar vacia");
        }
    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anio anio = (Anio) o;
        return Objects.equals(value, anio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
