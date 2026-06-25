package cl.duoc.ejemplo.ms.secucloud.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentaDto {

	private Long id;
	private String clienteId;
	private String clienteNombre;
	private Double monto;
	private LocalDate fecha;
	private String estado;
	private String descripcion;
}
