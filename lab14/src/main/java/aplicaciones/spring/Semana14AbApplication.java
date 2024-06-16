package aplicaciones.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class Semana14AbApplication implements CommandLineRunner{
    @Autowired
    
    private BCryptPasswordEncoder passEncripta;
    public static void main(String[] args) {
        SpringApplication.run(Semana14AbApplication.class, args);
    }
    
    public void run(String... args) throws Exception {
        String password1 = "user";
        String password2 = "admin";
        System.out.println(passEncripta.encode(password1));
        System.out.println(passEncripta.encode(password2));

    }
}