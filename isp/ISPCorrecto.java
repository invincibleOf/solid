package isp;

/**
 * ✅ CORRECTO - Interface Segregation Principle
 *
 * Las interfaces se separan por capacidad. Cada clase implementa
 * solo las interfaces que le corresponden según su naturaleza.
 * Ninguna clase se ve obligada a implementar algo que no tiene sentido.
 */

interface Laborable {
    void trabajar();
}

interface Alimentable {
    void comer();
}

interface Descansable {
    void dormir();
}

// El Humano implementa las tres porque las necesita todas ✅
class Humano implements Laborable, Alimentable, Descansable {
    @Override public void trabajar() { System.out.println("Humano trabajando"); }
    @Override public void comer()    { System.out.println("Humano comiendo"); }
    @Override public void dormir()   { System.out.println("Humano durmiendo"); }
}

// El Robot solo implementa lo que realmente hace ✅
class Robot implements Laborable {
    @Override public void trabajar() { System.out.println("Robot trabajando"); }
}

public class ISPCorrecto {
    public static void main(String[] args) {
        Humano humano = new Humano();
        humano.trabajar();
        humano.comer();
        humano.dormir();

        Robot robot = new Robot();
        robot.trabajar();
        // robot.comer() → ni siquiera existe el método ✅
    }
}
