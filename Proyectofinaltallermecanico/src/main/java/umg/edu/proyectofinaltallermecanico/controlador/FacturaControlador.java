package umg.edu.proyectofinaltallermecanico.controlador;

import umg.edu.proyectofinaltallermecanico.modelo.Factura;
import umg.edu.proyectofinaltallermecanico.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping
    public List<Factura> listar() {
        return facturaServicio.listarTodos();
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return facturaServicio.guardar(factura);
    }

    @GetMapping("/{id}")
    public Factura obtenerPorId(@PathVariable Long id) {
        return facturaServicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Factura actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaServicio.actualizar(id, factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facturaServicio.eliminar(id);
    }
}