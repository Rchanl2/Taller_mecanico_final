package umg.edu.proyectofinaltallermecanico.repositorio;

import umg.edu.proyectofinaltallermecanico.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
}