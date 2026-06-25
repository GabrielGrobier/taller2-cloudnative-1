package cl.duoc.ejemplo.ms.secucloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.ejemplo.ms.secucloud.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

}
