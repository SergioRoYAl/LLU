package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import web.app.entity.NoticiaEntity;
import web.app.entity.ProductoEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.NoticiaRepository;

@Service
public class NoticiaService {
    
    @Autowired
    private NoticiaRepository oNoticiaRepository;

    @Autowired
    private SesionService oSesionService;

    public NoticiaEntity get(Long id){
        oSesionService.onlyAdmins();
        return oNoticiaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se ha podido encontrar el producto"));
        
    }

    public Page<NoticiaEntity> getPage(Pageable oPageable){
        oSesionService.onlyAdmins();
        return oNoticiaRepository.findAll(oPageable);
    }

   public Page<NoticiaEntity> getPageVisible(Pageable oPageable){

        return oNoticiaRepository.findAllVisible(oPageable);


        
    }

    public NoticiaEntity create(NoticiaEntity oNoticiaEntity){
        oSesionService.onlyAdmins();
        oNoticiaEntity.setId(null);
        return oNoticiaRepository.save(oNoticiaEntity);
    }

    public NoticiaEntity update(NoticiaEntity oNoticiaEntity){
        oSesionService.onlyAdmins();
        return oNoticiaRepository.save(oNoticiaEntity);
    }

    public Long delete(NoticiaEntity oNoticiaEntity){
        oSesionService.onlyAdmins();
        oNoticiaRepository.delete(oNoticiaEntity);
        return oNoticiaEntity.getId();
    }

}
