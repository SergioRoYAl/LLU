package web.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
     Optional<ProductoEntity> findByNombre(String nombre);

     @Query(value = "SELECT * FROM producto WHERE visible = 1 ORDER BY id ASC", nativeQuery = true)
Page<ProductoEntity> findAllVisible(Pageable pageable);

@Query(value = "SELECT * FROM producto WHERE length(?1) >= 3 AND (nombre LIKE %?1%)", nativeQuery = true)
     Page<ProductoEntity> findByNameContainingIgnoreCase(String searchText, String filter1, Pageable pageable);
}
