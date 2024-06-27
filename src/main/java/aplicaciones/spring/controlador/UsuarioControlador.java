package aplicaciones.spring.controlador;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aplicaciones.spring.modelo.Usuario;
import aplicaciones.spring.repositorios.IUsuario;

@Controller
public class UsuarioControlador {
	
	@Autowired
	private IUsuario UsuarioRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/registro")
	public String FormularioRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/registro")
	public String RegistroUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		UsuarioRepositorio.save(usuario);
		return "redirect:/iniciarsesion";
	}
	
	@GetMapping("/iniciarsesion")
	public String FormularioIniciarSesion() {
		return "iniciarsesion";
	}
	
}
