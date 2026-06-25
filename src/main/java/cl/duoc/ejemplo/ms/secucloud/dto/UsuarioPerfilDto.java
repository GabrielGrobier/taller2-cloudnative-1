package cl.duoc.ejemplo.ms.secucloud.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPerfilDto {

	private Long id;
	private String nombre;
	private String email;
	private String rol;
	private String departamento;
	private LocalDate fechaCreacion;
}
