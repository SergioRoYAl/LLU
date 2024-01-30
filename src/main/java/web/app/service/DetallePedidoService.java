package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.app.entity.DetallePedidoEntity;
import web.app.entity.DocumentoEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {
    
    @Autowired
    DetallePedidoRepository oDetallePedidoRepository;

    @Autowired
    SesionService oSesionService;

    public DetallePedidoEntity get(Long id){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(id);
        return oDetallePedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha podido encontrar el detalle del pedido"));
    }

    public DetallePedidoEntity create(DetallePedidoEntity oDetallePedidoEntity){
        oSesionService.onlyAdmins();
        oDetallePedidoEntity.setId(null);
        return oDetallePedidoRepository.save(oDetallePedidoEntity);
    }

    public DetallePedidoEntity update(DetallePedidoEntity oDetallePedidoEntity){
        oSesionService.onlyAdmins();
        return oDetallePedidoRepository.save(oDetallePedidoEntity);
    }

    public Long delete(Long id){
        oSesionService.onlyAdmins();
        oDetallePedidoRepository.deleteById(id);
        return id;
    }

    public Page<DetallePedidoEntity> getPage(Pageable oPageable){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());
        return oDetallePedidoRepository.findAll(oPageable);
    }

}
