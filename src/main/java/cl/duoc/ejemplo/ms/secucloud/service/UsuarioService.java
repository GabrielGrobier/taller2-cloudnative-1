package cl.duoc.ejemplo.ms.secucloud.service;

import org.springframework.stereotype.Service;

import cl.duoc.ejemplo.ms.secucloud.dto.UsuarioPerfilDto;
import cl.duoc.ejemplo.ms.secucloud.model.Usuario;
import cl.duoc.ejemplo.ms.secucloud.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	/**
	 * Retorna el perfil del primer usuario cargado (simula el usuario autenticado).
	 */
	public UsuarioPerfilDto obtenerPerfil() {

		Usuario usuario = usuarioRepository.findAll().stream().findFirst()
				.orElseThrow(() -> new RuntimeException("No existe ningún usuario en el sistema"));
		return toDto(usuario);
	}

	private UsuarioPerfilDto toDto(Usuario u) {

		return UsuarioPerfilDto.builder().id(u.getId()).nombre(u.getNombre()).email(u.getEmail()).rol(u.getRol())
				.departamento(u.getDepartamento()).fechaCreacion(u.getFechaCreacion()).build();
	}
}
