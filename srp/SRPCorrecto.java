package srp;

/**
 * ✅ CORRECTO - Single Responsibility Principle
 *
 * Cada clase tiene UNA sola razón para cambiar:
 *  - UsuarioValidator   → solo valida
 *  - UsuarioRepository  → solo persiste
 *  - UsuarioNotificador → solo notifica
 *  - UsuarioService     → solo orquesta el flujo de negocio
 */

// --- Clase 1: solo validación ---
class UsuarioValidator {
    public void validar(String nombre, String email) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}

// --- Clase 2: solo persistencia ---
class UsuarioRepository {
    public void guardar(String nombre, String email) {
        System.out.println("INSERT INTO usuarios (nombre, email) VALUES ('" + nombre + "', '" + email + "')");
    }
}

// --- Clase 3: solo notificaciones ---
class UsuarioNotificador {
    public void enviarBienvenida(String email) {
        System.out.println("Enviando correo de bienvenida a: " + email);
    }
}

// --- Clase 4: orquesta el flujo, delega responsabilidades ---
public class SRPCorrecto {

    private final UsuarioValidator validator = new UsuarioValidator();
    private final UsuarioRepository repository = new UsuarioRepository();
    private final UsuarioNotificador notificador = new UsuarioNotificador();

    public void registrarUsuario(String nombre, String email) {
        validator.validar(nombre, email);
        repository.guardar(nombre, email);
        notificador.enviarBienvenida(email);
    }
}
