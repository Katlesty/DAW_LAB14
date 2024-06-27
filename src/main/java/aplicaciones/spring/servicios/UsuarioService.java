package aplicaciones.spring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Usuario;
import aplicaciones.spring.repositorios.IUsuario;



@Service
public class UsuarioService {
	
    @Autowired
    private IUsuario UsuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        UsuarioRepositorio.save(usuario);
    }

    public Usuario findByUsername(String username) {
        return UsuarioRepositorio.findByUsername(username);
    }
}
