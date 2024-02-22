package web.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.entity.DetallePedidoEntity;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, Long>{
    
     @Query(value = "SELECT dp.* FROM detallepedido dp WHERE dp.id_documento = ?1", nativeQuery = true)
     Page<DetallePedidoEntity> findByDocumentoId(Long id, Pageable pageable);
     
     @Query(value = "SELECT dp.* FROM detallepedido dp WHERE dp.id_documento = ?1 AND dp.id_producto = ?2", nativeQuery = true)
     DetallePedidoEntity findByDocumentoIdAndProductId(Long id, Long idProduct);


}
