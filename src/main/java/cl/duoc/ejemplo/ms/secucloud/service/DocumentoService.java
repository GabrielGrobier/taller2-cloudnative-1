package cl.duoc.ejemplo.ms.secucloud.service;

import org.springframework.stereotype.Service;

import cl.duoc.ejemplo.ms.secucloud.dto.DocumentoDto;
import cl.duoc.ejemplo.ms.secucloud.model.Documento;
import cl.duoc.ejemplo.ms.secucloud.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentoService {

	private final DocumentoRepository documentoRepository;

	public DocumentoDto obtenerDocumento(Long id) {

		Documento doc = documentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Documento no encontrado con id: " + id));
		return toDto(doc);
	}

	public void eliminarDocumento(Long id) {

		if (!documentoRepository.existsById(id)) {

			throw new RuntimeException("Documento no encontrado con id: " + id);
		}
		documentoRepository.deleteById(id);
	}

	private DocumentoDto toDto(Documento d) {

		return DocumentoDto.builder().id(d.getId()).nombre(d.getNombre()).tipo(d.getTipo())
				.fechaCreacion(d.getFechaCreacion()).ventaId(d.getVentaId()).descripcion(d.getDescripcion()).build();
	}
}
