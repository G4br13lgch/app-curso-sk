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
public class LibroDTO {
	private Integer idLibro ;
	private String titulo;
	private String ISBN;
	private Date fechaPublicacion;
	private Integer cantidadDisponible;
	private Integer idAutor;
	private String nombreAutor;
	private Integer idEditorial;
	private String nombreEditorial;
	private Integer idCategoria;
	private String nombreCategoria;
}
