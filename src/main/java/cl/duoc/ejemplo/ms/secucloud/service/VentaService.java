package cl.duoc.ejemplo.ms.secucloud.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.ejemplo.ms.secucloud.dto.VentaDto;
import cl.duoc.ejemplo.ms.secucloud.dto.VentaRequestDto;
import cl.duoc.ejemplo.ms.secucloud.model.Venta;
import cl.duoc.ejemplo.ms.secucloud.repository.VentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaService {

	private final VentaRepository ventaRepository;

	public List<VentaDto> listarVentas() {

		return ventaRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	public VentaDto crearVenta(VentaRequestDto request) {

		Venta venta = Venta.builder().clienteId(request.getClienteId()).clienteNombre(request.getClienteNombre())
				.monto(request.getMonto()).descripcion(request.getDescripcion()).fecha(LocalDate.now())
				.estado("PENDIENTE").build();
		return toDto(ventaRepository.save(venta));
	}

	private VentaDto toDto(Venta v) {

		return VentaDto.builder().id(v.getId()).clienteId(v.getClienteId()).clienteNombre(v.getClienteNombre())
				.monto(v.getMonto()).fecha(v.getFecha()).estado(v.getEstado()).descripcion(v.getDescripcion()).build();
	}
}
