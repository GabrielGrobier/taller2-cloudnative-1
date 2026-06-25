package cl.duoc.ejemplo.ms.secucloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.ejemplo.ms.secucloud.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
