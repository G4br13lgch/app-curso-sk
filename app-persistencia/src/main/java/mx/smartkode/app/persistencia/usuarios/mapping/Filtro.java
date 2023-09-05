package mx.smartkode.app.persistencia.usuarios.mapping;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filtro {

	private Integer idRol;
	private String usuario;
	private String correo;
	private String nombre;
}
