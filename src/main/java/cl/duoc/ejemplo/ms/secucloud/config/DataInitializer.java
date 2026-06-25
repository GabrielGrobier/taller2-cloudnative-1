package cl.duoc.ejemplo.ms.secucloud.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cl.duoc.ejemplo.ms.secucloud.model.Documento;
import cl.duoc.ejemplo.ms.secucloud.model.Usuario;
import cl.duoc.ejemplo.ms.secucloud.model.Venta;
import cl.duoc.ejemplo.ms.secucloud.repository.DocumentoRepository;
import cl.duoc.ejemplo.ms.secucloud.repository.UsuarioRepository;
import cl.duoc.ejemplo.ms.secucloud.repository.VentaRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

	private final UsuarioRepository usuarioRepository;
	private final VentaRepository ventaRepository;
	private final DocumentoRepository documentoRepository;

	@Override
	public void run(ApplicationArguments args) {

		usuarioRepository.saveAll(List.of(
				Usuario.builder().nombre("Ana Gonzalez").email("ana.gonzalez@secucloud.cl").rol("ADMINISTRADOR")
						.departamento("Tecnologia").fechaCreacion(LocalDate.of(2024, 1, 15)).build(),
				Usuario.builder().nombre("Carlos Rojas").email("carlos.rojas@secucloud.cl").rol("VENDEDOR")
						.departamento("Comercial").fechaCreacion(LocalDate.of(2024, 3, 10)).build(),
				Usuario.builder().nombre("Maria Fernandez").email("maria.fernandez@secucloud.cl").rol("VENDEDOR")
						.departamento("Comercial").fechaCreacion(LocalDate.of(2024, 6, 1)).build()));

		List<Venta> ventas = ventaRepository.saveAll(List.of(
				Venta.builder().clienteId("CLI-001").clienteNombre("Empresa ABC Ltda.").monto(1250000.00)
						.fecha(LocalDate.of(2026, 4, 10)).estado("COMPLETADA")
						.descripcion("Licencias software corporativo").build(),
				Venta.builder().clienteId("CLI-002").clienteNombre("Comercial XYZ S.A.").monto(875500.00)
						.fecha(LocalDate.of(2026, 4, 22)).estado("COMPLETADA")
						.descripcion("Servicio de mantencion anual").build(),
				Venta.builder().clienteId("CLI-003").clienteNombre("Distribuidora Norte").monto(320000.00)
						.fecha(LocalDate.of(2026, 5, 1)).estado("PENDIENTE").descripcion("Consultoria cloud 10 horas")
						.build(),
				Venta.builder().clienteId("CLI-001").clienteNombre("Empresa ABC Ltda.").monto(540000.00)
						.fecha(LocalDate.of(2026, 5, 8)).estado("PENDIENTE").descripcion("Ampliacion de licencias")
						.build(),
				Venta.builder().clienteId("CLI-004").clienteNombre("Tech Solutions SpA").monto(2100000.00)
						.fecha(LocalDate.of(2026, 5, 12)).estado("CANCELADA")
						.descripcion("Implementacion ERP - cliente cancelo").build()));

		documentoRepository.saveAll(List.of(
				Documento.builder().nombre("Factura-001-ABC.pdf").tipo("FACTURA")
						.fechaCreacion(LocalDate.of(2026, 4, 10)).ventaId(ventas.get(0).getId())
						.descripcion("Factura venta licencias Empresa ABC").build(),
				Documento.builder().nombre("Boleta-002-XYZ.pdf").tipo("BOLETA").fechaCreacion(LocalDate.of(2026, 4, 22))
						.ventaId(ventas.get(1).getId()).descripcion("Boleta servicio mantencion XYZ").build(),
				Documento.builder().nombre("OrdenCompra-003-Norte.pdf").tipo("ORDEN_COMPRA")
						.fechaCreacion(LocalDate.of(2026, 5, 1)).ventaId(ventas.get(2).getId())
						.descripcion("Orden de compra consultoria").build(),
				Documento.builder().nombre("Comprobante-004-ABC.pdf").tipo("COMPROBANTE_PAGO")
						.fechaCreacion(LocalDate.of(2026, 5, 8)).ventaId(ventas.get(3).getId())
						.descripcion("Comprobante pago ampliacion licencias").build(),
				Documento.builder().nombre("Factura-005-Tech.pdf").tipo("FACTURA")
						.fechaCreacion(LocalDate.of(2026, 5, 12)).ventaId(ventas.get(4).getId())
						.descripcion("Factura venta cancelada Tech Solutions").build()));
	}
}
