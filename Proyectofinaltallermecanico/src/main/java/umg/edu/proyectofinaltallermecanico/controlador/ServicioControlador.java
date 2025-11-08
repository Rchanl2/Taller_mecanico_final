package umg.edu.proyectofinaltallermecanico.controlador;

import umg.edu.proyectofinaltallermecanico.modelo.Servicio;
import umg.edu.proyectofinaltallermecanico.servicio.ServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioControlador {

    @Autowired
    private ServicioServicio servicioServicio;

    @GetMapping
    public List<Servicio> listar() {
        return servicioServicio.listarTodos();
    }

    @PostMapping
    public Servicio guardar(@RequestBody Servicio servicio) {
        return servicioServicio.guardar(servicio);
    }

    @GetMapping("/{id}")
    public Servicio obtenerPorId(@PathVariable Long id) {
        return servicioServicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Servicio actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        return servicioServicio.actualizar(id, servicio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioServicio.eliminar(id);
    }
}