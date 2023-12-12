package web.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
    Optional<UsuarioEntity> findByUsername(String username);

    Optional<UsuarioEntity> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT u.*,count(r.id) FROM usuario u, respuesta r WHERE u.id = r.id_usuario GROUP BY u.id ORDER BY COUNT(u.id) desc", nativeQuery = true)
    Page<UsuarioEntity> findUsersByRepliesNumberDescFilter(Pageable pageable);

}
