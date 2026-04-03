package lsp;

/**
 * ✅ CORRECTO - Liskov Substitution Principle
 *
 * La solución es NO forzar una jerarquía de herencia que rompa contratos.
 * Cuadrado y Rectángulo son formas independientes que comparten
 * una abstracción común (Forma), sin que una extienda a la otra.
 *
 * Cualquier Forma puede sustituir a otra sin romper el comportamiento esperado.
 */

// Abstracción común sin compromisos de implementación
interface Forma {
    int calcularArea();
}

class RectanguloOK implements Forma {
    private final int ancho;
    private final int alto;

    public RectanguloOK(int ancho, int alto) {
        this.ancho = ancho;
        this.alto  = alto;
    }

    @Override
    public int calcularArea() {
        return ancho * alto;
    }
}

class CuadradoOK implements Forma {
    private final int lado;

    public CuadradoOK(int lado) {
        this.lado = lado;
    }

    @Override
    public int calcularArea() {
        return lado * lado;
    }
}

public class LSPCorrecto {

    // Este método funciona correctamente con CUALQUIER Forma ✅
    static void imprimirArea(Forma forma) {
        System.out.println("Área: " + forma.calcularArea());
    }

    public static void main(String[] args) {
        imprimirArea(new RectanguloOK(5, 4)); // Área: 20 ✅
        imprimirArea(new CuadradoOK(4));      // Área: 16 ✅
    }
}
