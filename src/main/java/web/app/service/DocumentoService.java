package web.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import web.app.entity.DocumentoEntity;
import web.app.entity.UsuarioEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.DocumentoRepository;

@Service
public class DocumentoService {


    @Autowired
    DocumentoRepository oDocumentoRepository;

    @Autowired
    SesionService oSesionService;

    @Autowired
    HttpServletRequest oHttpServletRequest;


    public DocumentoEntity get(Long id){
        oSesionService.onlyAdmins();
        return oDocumentoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Documento no encontrado"));
    }


    public DocumentoEntity create(DocumentoEntity oDocumentoEntity){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());;
        oDocumentoEntity.setId(null);
        return oDocumentoRepository.save(oDocumentoEntity);
    }

    public DocumentoEntity update(DocumentoEntity oDocumentoEntity){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());
        return oDocumentoRepository.save(oDocumentoEntity);
    }

    public Long delete(DocumentoEntity oDocumentoEntity){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());
        oDocumentoRepository.delete(oDocumentoEntity);
        return oDocumentoEntity.getId();
    }

    

    public Page<DocumentoEntity> getPage(Pageable oPageable){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());
        return oDocumentoRepository.findAll(oPageable);
    }

    public DocumentoEntity isPendiente(Long id){
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oSesionService.getSessionUsuario().getId());
        return oDocumentoRepository.isPendiente(id);
    }
    
}
