package cl.duoc.ejemplo.ms.secucloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ejemplo.ms.secucloud.dto.UsuarioPerfilDto;
import cl.duoc.ejemplo.ms.secucloud.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	/**
	 * GET /usuarios/perfil Retorna el perfil del usuario actualmente autenticado
	 * (simulado).
	 */
	@GetMapping("/perfil")
	public ResponseEntity<UsuarioPerfilDto> obtenerPerfil() {

		return ResponseEntity.ok(usuarioService.obtenerPerfil());
	}
}
