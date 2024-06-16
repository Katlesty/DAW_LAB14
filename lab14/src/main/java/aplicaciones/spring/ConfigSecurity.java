package aplicaciones.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private BCryptPasswordEncoder passEncripta;
	
	public void autenticacion(AuthenticationManagerBuilder builder) {
		try {
			builder.jdbcAuthentication()
				.dataSource(ds)
				.passwordEncoder(passEncripta)
				.usersByUsernameQuery("select usuario,password,activo from usuarios where usuario=?")
				.authoritiesByUsernameQuery("select usuario,rol_nombre from roles inner join usuarios on roles.usu_codigo = usuarios.usu_codigo where usuario=?");
		}catch (Exception e){
			
		}
	}
	
}
