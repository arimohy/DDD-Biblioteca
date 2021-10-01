package co.com.sofka.DDDBiblioteca.domain.biblioteca.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HorarioInicio implements ValueObject<String> {
    private final String value;

    public HorarioInicio(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La hora de inicio no puede estar vacia");
        }
    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioInicio that = (HorarioInicio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
