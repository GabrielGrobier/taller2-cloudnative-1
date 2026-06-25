package cl.duoc.ejemplo.ms.secucloud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ejemplo.ms.secucloud.dto.VentaDto;
import cl.duoc.ejemplo.ms.secucloud.dto.VentaRequestDto;
import cl.duoc.ejemplo.ms.secucloud.service.VentaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

	private final VentaService ventaService;

	/**
	 * GET /ventas Lista todas las ventas registradas.
	 */
	@GetMapping
	public ResponseEntity<List<VentaDto>> listarVentas() {

		return ResponseEntity.ok(ventaService.listarVentas());
	}

	/**
	 * POST /ventas Registra una nueva venta con estado PENDIENTE.
	 *
	 * Body JSON: clienteId – identificador del cliente clienteNombre – nombre
	 * completo del cliente monto – monto de la venta descripcion – descripción del
	 * producto o servicio
	 */
	@PostMapping
	public ResponseEntity<VentaDto> crearVenta(@RequestBody VentaRequestDto request) {

		VentaDto creada = ventaService.crearVenta(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(creada);
	}
}
