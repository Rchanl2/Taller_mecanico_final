package umg.edu.proyectofinaltallermecanico.repositorio;

import umg.edu.proyectofinaltallermecanico.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {
}