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

    @Query(value = "SELECT * FROM usuario WHERE length(?1) >= 3 AND (nombre LIKE %?1% OR apellidos LIKE %?1% OR username LIKE %?1% OR email LIKE %?1%)", nativeQuery = true)
    Page<UsuarioEntity> findByUserByNameOrSurnameOrLastnameContainingIgnoreCase(String searchText,
            String filter, String filter2, String filter3, Pageable pageable);
}
