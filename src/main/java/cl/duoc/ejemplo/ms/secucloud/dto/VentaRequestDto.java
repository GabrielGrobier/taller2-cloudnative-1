package cl.duoc.ejemplo.ms.secucloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequestDto {

	private String clienteId;
	private String clienteNombre;
	private Double monto;
	private String descripcion;
}
