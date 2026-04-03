package dip;

/**
 * ❌ INCORRECTO - Dependency Inversion Principle
 *
 * PedidoService depende DIRECTAMENTE de MySQLPedidoRepository (clase concreta).
 * Si mañana queremos cambiar a PostgreSQL, MongoDB, o un mock para tests,
 * hay que modificar PedidoService → alto acoplamiento.
 *
 * El módulo de alto nivel (Service) depende del módulo de bajo nivel (Repository concreto).
 */
class MySQLPedidoRepository {
    public void guardar(String pedido) {
        System.out.println("[MySQL] Guardando pedido: " + pedido);
    }
}

public class DIPIncorrecto {

    // ❌ Dependencia directa en la clase concreta
    private MySQLPedidoRepository repository = new MySQLPedidoRepository();

    public void realizarPedido(String pedido) {
        // lógica de negocio...
        repository.guardar(pedido);
    }
}
