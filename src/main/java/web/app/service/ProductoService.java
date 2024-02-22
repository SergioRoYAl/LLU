package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.app.entity.ProductoEntity;
import web.app.entity.UsuarioEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SesionService oSesionService;

    public ProductoEntity get(Long id){
        if(true){
            return productoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        } else {
            throw new ResourceNotFoundException("Producto no encontrado");
        }
        
    }
    
    public Page<ProductoEntity> getPageVisible(Pageable oPageable, String filter){


        Page<ProductoEntity> page;

        if (filter == null || filter.isEmpty() || filter.trim().isEmpty()) {
            page = productoRepository.findAllVisible(oPageable);
        } else {
            page = productoRepository.findByNameContainingIgnoreCase(
                    filter, filter, oPageable);
        }
        return page;


        
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
