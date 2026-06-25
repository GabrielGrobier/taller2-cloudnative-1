package cl.duoc.ejemplo.ms.secucloud.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoDto {

	private Long id;
	private String nombre;
	private String tipo;
	private LocalDate fechaCreacion;
	private Long ventaId;
	private String descripcion;
}
