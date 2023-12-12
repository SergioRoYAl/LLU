package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.app.entity.DetallePedidoEntity;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, Long>{
    
}
