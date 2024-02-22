package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.entity.DocumentoEntity;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {

    @Query(value = "SELECT d.* FROM documento d WHERE d.id_usuario = ?1 AND d.fecha_pedido IS NULL", nativeQuery = true)
    DocumentoEntity isPendiente(Long id);

}
