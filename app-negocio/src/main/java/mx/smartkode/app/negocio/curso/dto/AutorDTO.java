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
public class AutorDTO {
	private Integer idAutor;
	private String nombre;
	private String apellidos;
	private String biografia;
}
