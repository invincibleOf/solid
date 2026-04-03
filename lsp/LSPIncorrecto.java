package lsp;

/**
 * ❌ INCORRECTO - Liskov Substitution Principle
 *
 * El problema clásico: Cuadrado extends Rectángulo.
 * Parece lógico geométricamente, pero ROMPE el contrato de Rectángulo.
 *
 * Si cualquier código que usa Rectángulo recibe un Cuadrado en su lugar,
 * el comportamiento deja de ser el esperado → viola LSP.
 */
class Rectangulo {
    protected int ancho;
    protected int alto;

    public void setAncho(int ancho) { this.ancho = ancho; }
    public void setAlto(int alto)   { this.alto = alto; }

    public int calcularArea() {
        return ancho * alto;
    }
}

class Cuadrado extends Rectangulo {
    // Un cuadrado fuerza ancho == alto, rompiendo el contrato del padre
    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.alto  = ancho; // ❌ efecto secundario inesperado
    }

    @Override
    public void setAlto(int alto) {
        this.alto  = alto;
        this.ancho = alto;  // ❌ efecto secundario inesperado
    }
}

public class LSPIncorrecto {
    // Este método espera que setAncho y setAlto sean independientes
    static void imprimirArea(Rectangulo r) {
        r.setAncho(5);
        r.setAlto(4);
        // Con Rectangulo → 20 ✅
        // Con Cuadrado   → 16 ❌ (el contrato se rompe)
        System.out.println("Área esperada: 20, Área real: " + r.calcularArea());
    }

    public static void main(String[] args) {
        imprimirArea(new Rectangulo()); // Área esperada: 20, Área real: 20
        imprimirArea(new Cuadrado());   // Área esperada: 20, Área real: 16 ❌
    }
}
