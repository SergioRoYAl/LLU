package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.app.entity.ProductoEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SesionService oSesionService;

    public ProductoEntity get(Long id){
        if(oSesionService.isAdmin()){
            return productoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
        
    }
    
    //DEPENDIENDO DE SI LA VISTA ES DEL ADMIN O DEL USER, HAY QUE CAMBIAR EL MÉTODO EN ANGULAR
    public ProductoEntity getByNombre(String nombre){
        if(oSesionService.isSessionActive()){
            return productoRepository.findByNombre(nombre)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
    }

    public Page<ProductoEntity> getPageVisible(Pageable oPageable){
        return productoRepository.findAllVisible(oPageable);
    }

    public Page<ProductoEntity> getPageFull(Pageable oPageable){
        if(oSesionService.isAdmin()){
            return productoRepository.findAll(oPageable);
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
    }

    public Long create(ProductoEntity oProductoEntity){
        oSesionService.onlyAdmins();
        oProductoEntity.setId(null);
        return productoRepository.save(oProductoEntity).getId();
    }

    public ProductoEntity update(ProductoEntity oProductoEntity){
        if(oSesionService.isAdmin()){
            return productoRepository.save(oProductoEntity);
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
    }

    public Long delete(ProductoEntity oProductoEntity){
        if(oSesionService.isAdmin()){
            productoRepository.delete(oProductoEntity);
            return oProductoEntity.getId();
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
    }


    
}
