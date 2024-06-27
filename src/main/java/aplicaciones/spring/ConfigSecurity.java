package aplicaciones.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private BCryptPasswordEncoder passEncripta;
	
	public void autenticacion(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(ds)
			.passwordEncoder(passEncripta)
			.usersByUsernameQuery("select * from usuario where username = ?")
			.authoritiesByUsernameQuery("select username, 'ROLE_USER' as role from usuario where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/registro","/iniciarsesion").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/iniciarsesion")
			.defaultSuccessUrl("/ventas/listar",true)
			.permitAll()
		.and()
		.logout()
			.permitAll();
	}
}
