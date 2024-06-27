package aplicaciones.spring.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name="CLIENTE")
public class Cliente {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long codigo;
		
		@NotNull
		private String apellidos;
		
		@NotNull
		private String nombres;
		
		@NotNull
		private String dni;
		
		@NotNull
		private Integer telefono;
		
		@NotNull 
		private String direccion;
		
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		
		public Integer getTelefono() {
			return telefono;
		}
		public void setTelefono(Integer telefono) {
			this.telefono = telefono;
		}
		
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		@Override
		public String toString() {
			return "Cliente [codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + 
					", dni=" + dni + ", telefono=" + telefono + ", direccion=" + direccion + "]";
		}
}
