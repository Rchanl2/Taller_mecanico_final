package umg.edu.proyectofinaltallermecanico.controlador;

import umg.edu.proyectofinaltallermecanico.modelo.Vehiculo;
import umg.edu.proyectofinaltallermecanico.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoControlador {

    @Autowired
    private VehiculoServicio vehiculoServicio;

    @GetMapping
    public List<Vehiculo> listar() {
        return vehiculoServicio.listarTodos();
    }

    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo vehiculo) {
        return vehiculoServicio.guardar(vehiculo);
    }

    @GetMapping("/{id}")
    public Vehiculo obtenerPorId(@PathVariable Long id) {
        return vehiculoServicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Vehiculo actualizar(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return vehiculoServicio.actualizar(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        vehiculoServicio.eliminar(id);
    }
}