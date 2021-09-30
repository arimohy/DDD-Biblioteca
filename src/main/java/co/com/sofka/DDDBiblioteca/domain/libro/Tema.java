package co.com.sofka.DDDBiblioteca.domain.libro;

import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.TemaPrincipal;
import co.com.sofka.domain.generic.Entity;

public class Tema extends Entity<TemaId> {
    private TemaPrincipal temaPrincipal;

    public Tema(TemaId entityId, TemaPrincipal temaPrincipal) {
        super(entityId);
        this.temaPrincipal = temaPrincipal;
    }

    public TemaPrincipal temaPrincipal() {
        return temaPrincipal;
    }

    public void actualizarTemaPrincipal(TemaPrincipal temaPrincipal) {
        this.temaPrincipal = temaPrincipal;
    }
}
