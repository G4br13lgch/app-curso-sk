package mx.smartkode.app.negocio.curso.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestamoDTO {
	private Integer idPrestamo;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private Integer idLibro;
	private String tituloLibro;
	private Integer idUsuario;
	private String nombreUsuario;
	private String apellidosUsuario;
}
