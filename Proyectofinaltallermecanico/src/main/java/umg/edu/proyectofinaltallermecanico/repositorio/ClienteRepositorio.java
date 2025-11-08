package umg.edu.proyectofinaltallermecanico.repositorio;

import umg.edu.proyectofinaltallermecanico.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}