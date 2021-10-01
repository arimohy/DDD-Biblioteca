package co.com.sofka.DDDBiblioteca.usecase;

public interface EnvioDeCorreoService {
    boolean enviarCorreo(String emailDestino,String asunto,String mensaje);
}
