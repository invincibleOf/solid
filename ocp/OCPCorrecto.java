package ocp;

/**
 * ✅ CORRECTO - Open/Closed Principle
 *
 * La clase CalculadoraDescuento está CERRADA a modificación pero
 * ABIERTA a extensión: para agregar un nuevo tipo de descuento solo
 * se crea una nueva clase que implemente EstrategiaDescuento.
 * Nunca se toca el código existente.
 */

// Abstracción: contrato para cualquier tipo de descuento
interface EstrategiaDescuento {
    double calcular(double precio);
}

// Extensión 1: sin modificar nada existente
class DescuentoVIP implements EstrategiaDescuento {
    @Override
    public double calcular(double precio) {
        return precio * 0.20;
    }
}

// Extensión 2
class DescuentoRegular implements EstrategiaDescuento {
    @Override
    public double calcular(double precio) {
        return precio * 0.10;
    }
}

// Extensión 3
class DescuentoNuevo implements EstrategiaDescuento {
    @Override
    public double calcular(double precio) {
        return precio * 0.05;
    }
}

// Extensión 4: mañana llega este requerimiento → solo agrego esta clase ✅
class DescuentoEmpleado implements EstrategiaDescuento {
    @Override
    public double calcular(double precio) {
        return precio * 0.30;
    }
}

// La calculadora no cambia nunca, solo recibe la estrategia correcta
public class OCPCorrecto {

    public double calcularDescuento(EstrategiaDescuento estrategia, double precio) {
        return estrategia.calcular(precio);
    }

    public static void main(String[] args) {
        OCPCorrecto calculadora = new OCPCorrecto();
        System.out.println(calculadora.calcularDescuento(new DescuentoVIP(), 100));      // 20.0
        System.out.println(calculadora.calcularDescuento(new DescuentoEmpleado(), 100)); // 30.0
    }
}
