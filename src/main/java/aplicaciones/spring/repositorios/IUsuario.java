package aplicaciones.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.Usuario;


@Repository
public interface IUsuario extends JpaRepository<Usuario,Long> {
	Usuario findByUsername(String username);
}

