package dip;

/**
 * ✅ CORRECTO - Dependency Inversion Principle
 *
 * PedidoService depende de la ABSTRACCIÓN (PedidoRepository interface),
 * no de ninguna implementación concreta.
 *
 * Cambiar de MySQL a PostgreSQL, a un repositorio en memoria para tests,
 * o a cualquier otra tecnología NO requiere tocar PedidoService.
 *
 * Esto es exactamente lo que hace Spring Boot con @Service + @Repository:
 * el servicio recibe la interfaz por inyección de dependencias.
 */

// Abstracción: el contrato que cualquier repositorio debe cumplir
interface PedidoRepository {
    void guardar(String pedido);
}

// Implementación concreta MySQL
class MySQLPedidoRepositoryOK implements PedidoRepository {
    @Override
    public void guardar(String pedido) {
        System.out.println("[MySQL] Guardando pedido: " + pedido);
    }
}

// Implementación concreta PostgreSQL (solo se agrega, nada se modifica)
class PostgreSQLPedidoRepository implements PedidoRepository {
    @Override
    public void guardar(String pedido) {
        System.out.println("[PostgreSQL] Guardando pedido: " + pedido);
    }
}

// Implementación en memoria para tests (útil en unit tests sin BD)
class InMemoryPedidoRepository implements PedidoRepository {
    @Override
    public void guardar(String pedido) {
        System.out.println("[InMemory] Guardando pedido: " + pedido);
    }
}

// El servicio de alto nivel depende solo de la abstracción ✅
public class DIPCorrecto {

    private final PedidoRepository repository;

    // La dependencia se inyecta desde afuera (Constructor Injection)
    public DIPCorrecto(PedidoRepository repository) {
        this.repository = repository;
    }

    public void realizarPedido(String pedido) {
        // lógica de negocio...
        repository.guardar(pedido);
    }

    public static void main(String[] args) {
        // En producción con MySQL
        DIPCorrecto servicioMySQL = new DIPCorrecto(new MySQLPedidoRepositoryOK());
        servicioMySQL.realizarPedido("Laptop");

        // En producción con PostgreSQL → sin tocar DIPCorrecto
        DIPCorrecto servicioPostgres = new DIPCorrecto(new PostgreSQLPedidoRepository());
        servicioPostgres.realizarPedido("Monitor");

        // En tests → sin tocar DIPCorrecto
        DIPCorrecto servicioTest = new DIPCorrecto(new InMemoryPedidoRepository());
        servicioTest.realizarPedido("Teclado");
    }
}
