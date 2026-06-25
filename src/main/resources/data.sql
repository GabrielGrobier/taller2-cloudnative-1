-- ─────────────────────────────────────────────────────────────────────────────
-- SEEDS INICIALES – ms-secucloud
-- Se cargan automáticamente al iniciar el microservicio.
-- ─────────────────────────────────────────────────────────────────────────────

-- ── Usuarios ─────────────────────────────────────────────────────────────────
INSERT INTO usuarios (nombre, email, rol, departamento, fecha_creacion) VALUES ('Ana Gonzalez', 'ana.gonzalez@secucloud.cl', 'ADMINISTRADOR', 'Tecnologia', '2024-01-15');
INSERT INTO usuarios (nombre, email, rol, departamento, fecha_creacion) VALUES ('Carlos Rojas', 'carlos.rojas@secucloud.cl', 'VENDEDOR', 'Comercial', '2024-03-10');
INSERT INTO usuarios (nombre, email, rol, departamento, fecha_creacion) VALUES ('Maria Fernandez', 'maria.fernandez@secucloud.cl', 'VENDEDOR', 'Comercial', '2024-06-01');

-- ── Ventas ───────────────────────────────────────────────────────────────────
INSERT INTO ventas (cliente_id, cliente_nombre, monto, fecha, estado, descripcion) VALUES ('CLI-001', 'Empresa ABC Ltda.', 1250000.00, '2026-04-10', 'COMPLETADA', 'Licencias software corporativo');
INSERT INTO ventas (cliente_id, cliente_nombre, monto, fecha, estado, descripcion) VALUES ('CLI-002', 'Comercial XYZ S.A.', 875500.00, '2026-04-22', 'COMPLETADA', 'Servicio de mantencion anual');
INSERT INTO ventas (cliente_id, cliente_nombre, monto, fecha, estado, descripcion) VALUES ('CLI-003', 'Distribuidora Norte', 320000.00, '2026-05-01', 'PENDIENTE', 'Consultoria cloud 10 horas');
INSERT INTO ventas (cliente_id, cliente_nombre, monto, fecha, estado, descripcion) VALUES ('CLI-001', 'Empresa ABC Ltda.', 540000.00, '2026-05-08', 'PENDIENTE', 'Ampliacion de licencias');
INSERT INTO ventas (cliente_id, cliente_nombre, monto, fecha, estado, descripcion) VALUES ('CLI-004', 'Tech Solutions SpA', 2100000.00, '2026-05-12', 'CANCELADA', 'Implementacion ERP - cliente cancelo');

-- ── Documentos ───────────────────────────────────────────────────────────────
INSERT INTO documentos (nombre, tipo, fecha_creacion, venta_id, descripcion) VALUES ('Factura-001-ABC.pdf', 'FACTURA', '2026-04-10', 1, 'Factura venta licencias Empresa ABC');
INSERT INTO documentos (nombre, tipo, fecha_creacion, venta_id, descripcion) VALUES ('Boleta-002-XYZ.pdf', 'BOLETA', '2026-04-22', 2, 'Boleta servicio mantencion XYZ');
INSERT INTO documentos (nombre, tipo, fecha_creacion, venta_id, descripcion) VALUES ('OrdenCompra-003-Norte.pdf', 'ORDEN_COMPRA', '2026-05-01', 3, 'Orden de compra consultoria');
INSERT INTO documentos (nombre, tipo, fecha_creacion, venta_id, descripcion) VALUES ('Comprobante-004-ABC.pdf', 'COMPROBANTE_PAGO', '2026-05-08', 4, 'Comprobante pago ampliacion licencias');
INSERT INTO documentos (nombre, tipo, fecha_creacion, venta_id, descripcion) VALUES ('Factura-005-Tech.pdf', 'FACTURA', '2026-05-12', 5, 'Factura venta cancelada Tech Solutions');

