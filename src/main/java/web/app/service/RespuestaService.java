package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import web.app.entity.RespuestaEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.RespuestaRepository;

@Service
public class RespuestaService {
    
    @Autowired
    RespuestaRepository oRespuestaRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SesionService oSesionService;

    public RespuestaEntity get(Long id){
        oSesionService.onlyAdmins();
        return oRespuestaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada"));
        
    }

    public Long create(RespuestaEntity oRespuestaEntity){
        oSesionService.onlyAdmins();
        oRespuestaEntity.setId(null);
        return oRespuestaRepository.save(oRespuestaEntity).getId();
    }

    public Long update(RespuestaEntity oRespuestaEntity){
        oSesionService.onlyAdmins();
        return oRespuestaRepository.save(oRespuestaEntity).getId();
    }

    public Long delete(RespuestaEntity oRespuestaEntity){
        oSesionService.onlyAdmins();
        oRespuestaRepository.delete(oRespuestaEntity);
        return oRespuestaEntity.getId();
    }
}
