package mx.smartkode.app.negocio.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
	private Integer idCategoria;
	private String nombre;
	private String descripcion;
}
