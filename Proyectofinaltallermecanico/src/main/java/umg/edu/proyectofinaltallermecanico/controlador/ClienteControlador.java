package umg.edu.proyectofinaltallermecanico.controlador;

import umg.edu.proyectofinaltallermecanico.modelo.Cliente;
import umg.edu.proyectofinaltallermecanico.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public List<Cliente> listar() {
        return clienteServicio.listarTodos();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteServicio.guardar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable Long id) {
        return clienteServicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteServicio.actualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteServicio.eliminar(id);
    }
}