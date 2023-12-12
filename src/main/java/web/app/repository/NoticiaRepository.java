package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.NoticiaEntity;

public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long>  {
    
}
