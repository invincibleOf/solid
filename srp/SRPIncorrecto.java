package srp;

/**
 * ❌ INCORRECTO - Single Responsibility Principle
 *
 * Esta clase tiene MÚLTIPLES responsabilidades:
 *  1. Lógica de negocio del usuario
 *  2. Validación de datos
 *  3. Persistencia en base de datos
 *  4. Envío de correos
 *
 * Cualquier cambio en la BD, en el email o en las reglas de negocio
 * obliga a modificar esta misma clase → múltiples razones para cambiar.
 */
public class SRPIncorrecto {

    public void registrarUsuario(String nombre, String email) {

        // Responsabilidad 1: validación
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        // Responsabilidad 2: persistencia
        System.out.println("INSERT INTO usuarios (nombre, email) VALUES ('" + nombre + "', '" + email + "')");

        // Responsabilidad 3: notificación por correo
        System.out.println("Enviando correo de bienvenida a: " + email);
    }
}
