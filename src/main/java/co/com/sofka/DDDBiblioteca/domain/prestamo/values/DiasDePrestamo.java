package co.com.sofka.DDDBiblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DiasDePrestamo implements ValueObject<Integer> {
    private final Integer value;

    public DiasDePrestamo(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiasDePrestamo that = (DiasDePrestamo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
