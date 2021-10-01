package co.com.sofka.DDDBiblioteca.domain.libro.command;

import co.com.sofka.DDDBiblioteca.domain.libro.Ejemplar;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.EjemplarId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Estado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Ubicacion;

public class AgregarEjemplar extends Ejemplar {
    private final AutorId autorId;;
    private final EjemplarId entityId;
    private final Estado estado;
    private final Ubicacion ubicacion;

    public AgregarEjemplar(AutorId autorId,EjemplarId entityId, Estado estado, Ubicacion ubicacion, EjemplarId entityId1, Estado estado1, Ubicacion ubicacion1) {
        super(entityId, estado, ubicacion);
        this.autorId=autorId;
        this.entityId = entityId1;
        this.estado = estado1;
        this.ubicacion = ubicacion1;
    }

    public EjemplarId getEntityId() {
        return entityId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
