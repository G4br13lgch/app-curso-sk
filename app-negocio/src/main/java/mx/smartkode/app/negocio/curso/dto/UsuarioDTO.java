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
public class UsuarioDTO {
	private Integer idUsuario;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String password;
	private String correo;
	private Date fechaSesion;
	private String nomRo;
	private Integer idRol;
}
