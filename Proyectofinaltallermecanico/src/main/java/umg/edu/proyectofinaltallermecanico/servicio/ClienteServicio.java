package umg.edu.proyectofinaltallermecanico.servicio;

import umg.edu.proyectofinaltallermecanico.modelo.Cliente;
import umg.edu.proyectofinaltallermecanico.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> resultado = clienteRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente actualizar(Long id, Cliente nuevoCliente) {
        Cliente existente = buscarPorId(id);
        existente.setNombre(nuevoCliente.getNombre());
        existente.setIdentificacion(nuevoCliente.getIdentificacion());
        existente.setTipoIdentificacion(nuevoCliente.getTipoIdentificacion());
        return clienteRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }
}