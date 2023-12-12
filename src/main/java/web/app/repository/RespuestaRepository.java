package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.RespuestaEntity;

public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Long>{
    
}
