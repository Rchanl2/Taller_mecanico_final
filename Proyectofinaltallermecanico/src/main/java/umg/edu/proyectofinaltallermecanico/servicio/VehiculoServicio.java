package umg.edu.proyectofinaltallermecanico.servicio;

import umg.edu.proyectofinaltallermecanico.modelo.Vehiculo;
import umg.edu.proyectofinaltallermecanico.repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    public List<Vehiculo> listarTodos() {
        return vehiculoRepositorio.findAll();
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepositorio.save(vehiculo);
    }

    public Vehiculo buscarPorId(Long id) {
        Optional<Vehiculo> resultado = vehiculoRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }

    public Vehiculo actualizar(Long id, Vehiculo nuevoVehiculo) {
        Vehiculo existente = buscarPorId(id);
        existente.setPlaca(nuevoVehiculo.getPlaca());
        existente.setMarca(nuevoVehiculo.getMarca());
        existente.setModelo(nuevoVehiculo.getModelo());
        existente.setCliente(nuevoVehiculo.getCliente());
        return vehiculoRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        vehiculoRepositorio.deleteById(id);
    }
}