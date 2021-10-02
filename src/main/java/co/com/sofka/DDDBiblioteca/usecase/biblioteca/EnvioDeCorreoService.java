package co.com.sofka.DDDBiblioteca.usecase.biblioteca;

public interface EnvioDeCorreoService {
    boolean enviarCorreo(String emailDestino,String asunto,String mensaje);
}
