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
public class EditorialDTO {
	private Integer idEditorial;
	private String nombre;
	private String direccion;
}
