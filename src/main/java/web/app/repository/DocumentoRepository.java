package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.DocumentoEntity;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {
    
}
