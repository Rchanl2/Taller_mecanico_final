package umg.edu.proyectofinaltallermecanico.servicio;

import umg.edu.proyectofinaltallermecanico.modelo.Servicio;
import umg.edu.proyectofinaltallermecanico.repositorio.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio {

    @Autowired
    private ServicioRepositorio servicioRepositorio;

    public List<Servicio> listarTodos() {
        return servicioRepositorio.findAll();
    }

    public Servicio guardar(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }

    public Servicio buscarPorId(Long id) {
        Optional<Servicio> resultado = servicioRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    public Servicio actualizar(Long id, Servicio nuevoServicio) {
        Servicio existente = buscarPorId(id);
        existente.setDescripcion(nuevoServicio.getDescripcion());
        existente.setPrecio(nuevoServicio.getPrecio());
        return servicioRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        servicioRepositorio.deleteById(id);
    }
}