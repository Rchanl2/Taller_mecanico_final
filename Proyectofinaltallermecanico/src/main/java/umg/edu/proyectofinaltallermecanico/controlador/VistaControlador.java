package umg.edu.proyectofinaltallermecanico.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaControlador {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido al Taller Mecánico!");
        return "index"; // Carga index.html desde /templates
    }
}