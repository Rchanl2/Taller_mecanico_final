package umg.edu.proyectofinaltallermecanico.servicio;

import umg.edu.proyectofinaltallermecanico.modelo.Factura;
import umg.edu.proyectofinaltallermecanico.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Factura> listarTodos() {
        return facturaRepositorio.findAll();
    }

    public Factura guardar(Factura factura) {
        return facturaRepositorio.save(factura);
    }

    public Factura buscarPorId(Long id) {
        Optional<Factura> resultado = facturaRepositorio.findById(id);
        return resultado.orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public Factura actualizar(Long id, Factura nuevaFactura) {
        Factura existente = buscarPorId(id);
        existente.setFecha(nuevaFactura.getFecha());
        existente.setCliente(nuevaFactura.getCliente());
        existente.setVehiculo(nuevaFactura.getVehiculo());
        existente.setServicio(nuevaFactura.getServicio());
        return facturaRepositorio.save(existente);
    }

    public void eliminar(Long id) {
        facturaRepositorio.deleteById(id);
    }
}