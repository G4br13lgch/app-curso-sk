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
public class ResenaDTO {
	private Integer idResena;
	private String comentario;
	private Integer calificacion;
	private Date fecha;
	private Integer idLibro;
	private String tituloLibro;
	private Integer idUsuario;
	private String nombreUsuario;	
}
