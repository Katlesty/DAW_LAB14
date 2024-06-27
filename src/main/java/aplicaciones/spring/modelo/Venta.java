package aplicaciones.spring.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;
@Entity
@Table(name = "VENTAS")
public class Venta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@NotNull
	private String codigo_cli;
	
	@NotNull
	private String codigo_pro;
	
	@NotNull
	private Integer cantidad;
	
	private Double subtotal;
	private Double igv;
	private Double total;	
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo_cli() {
		return codigo_cli;
	}

	public void setCodigo_cli(String codigo_cli) {
		this.codigo_cli = codigo_cli;
	}

	public String getCodigo_pro() {
		return codigo_pro;
	}

	public void setCodigo_pro(String codigo_pro) {
		this.codigo_pro = codigo_pro;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", fecha=" + fecha + ", cliente_codigo=" + codigo_cli + ", producto_codigo=" + codigo_pro
				+ ", cantidad=" + cantidad + ", subtotal="+ subtotal + ", igv=" + igv + ", total=" + total + "]";
	}

}
