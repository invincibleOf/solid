package isp;

/**
 * ❌ INCORRECTO - Interface Segregation Principle
 *
 * Una interfaz "gorda" obliga a las clases a implementar métodos
 * que no necesitan. Un Robot no come ni duerme, pero se ve forzado
 * a implementar esos métodos → acoplamiento innecesario y código engañoso.
 */
interface Trabajador {
    void trabajar();
    void comer();   // ¿un Robot come?
    void dormir();  // ¿un Robot duerme?
}

class HumanoTrabajador implements Trabajador {
    @Override public void trabajar() { System.out.println("Humano trabajando"); }
    @Override public void comer()    { System.out.println("Humano comiendo"); }
    @Override public void dormir()   { System.out.println("Humano durmiendo"); }
}

class RobotTrabajador implements Trabajador {
    @Override public void trabajar() { System.out.println("Robot trabajando"); }

    // ❌ Métodos forzados que no tienen sentido para un Robot
    @Override public void comer()   { throw new UnsupportedOperationException("Los robots no comen"); }
    @Override public void dormir()  { throw new UnsupportedOperationException("Los robots no duermen"); }
}

public class ISPIncorrecto {}
