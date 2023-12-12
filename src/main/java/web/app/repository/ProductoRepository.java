package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
}
