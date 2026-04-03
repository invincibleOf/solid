package ocp;

/**
 * ❌ INCORRECTO - Open/Closed Principle
 *
 * Cada vez que se agrega un nuevo tipo de descuento, hay que MODIFICAR
 * esta clase. Esto viola OCP porque la clase no está cerrada a modificaciones.
 *
 * Agregar "EMPLEADO" u otro tipo obliga a tocar lógica ya probada.
 */
public class OCPIncorrecto {

    public double calcularDescuento(String tipoCliente, double precio) {
        if (tipoCliente.equals("VIP")) {
            return precio * 0.20;
        } else if (tipoCliente.equals("REGULAR")) {
            return precio * 0.10;
        } else if (tipoCliente.equals("NUEVO")) {
            return precio * 0.05;
        }
        // Si mañana llega "EMPLEADO", hay que modificar este método ❌
        return 0;
    }
}
