package cl.duoc.ejemplo.ms.secucloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ejemplo.ms.secucloud.dto.DocumentoDto;
import cl.duoc.ejemplo.ms.secucloud.service.DocumentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
public class DocumentoController {

	private final DocumentoService documentoService;

	/**
	 * GET /documentos/{id} Retorna los metadatos de un documento por su id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<DocumentoDto> obtenerDocumento(@PathVariable Long id) {

		return ResponseEntity.ok(documentoService.obtenerDocumento(id));
	}

	/**
	 * DELETE /documentos/{id} Elimina un documento por su id.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarDocumento(@PathVariable Long id) {

		documentoService.eliminarDocumento(id);
		return ResponseEntity.noContent().build();
	}
}
