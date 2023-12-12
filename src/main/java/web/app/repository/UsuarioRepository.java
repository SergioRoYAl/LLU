package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
}
