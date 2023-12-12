package web.app.service;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import web.app.entity.UsuarioEntity;
import web.app.exception.ResourceNotFoundException;
import web.app.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository oUsuarioRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SesionService oSesionService;

    public UsuarioEntity get(Long id){
        if(oSesionService.isSessionActive()){
            return oUsuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
    }

    public UsuarioEntity getByUsername(String username){
        if(oSesionService.isSessionActive()){
            return oUsuarioRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
    }

    public Page<UsuarioEntity> getPage(Pageable oPageable){
        oSesionService.onlyAdmins();
        return oUsuarioRepository.findAll(oPageable);
    }

    public Page<UsuarioEntity> getPageByRespuestasNumeroDescendiente(Pageable oPageable){
        oSesionService.onlyUsersWithItsOwnData(Long.parseLong(oHttpServletRequest.getAttribute("id").toString()));
        return oUsuarioRepository.findUsersByRepliesNumberDescFilter(oPageable);
    }

    public Long create (UsuarioEntity oUsuarioEntity){
        oSesionService.onlyAdmins();
        oUsuarioEntity.setId(null);
        oUsuarioEntity.setPassword("f295e358ac82ac23ffe6ff6f5ac94e8a6d8a455604826c64e36b29e0aa2dd4b3"); //qlfta
        return oUsuarioRepository.save(oUsuarioEntity).getId();
    }
    
    public UsuarioEntity update(UsuarioEntity oUsuarioEntityToSet){
        UsuarioEntity oUsuarioEntityFromDataBase = this.get(oUsuarioEntityToSet.getId());
        oSesionService.onlyAdminsOrUsersWithIisOwnData(oUsuarioEntityFromDataBase.getId());
        if(oSesionService.isUser()){
            oUsuarioEntityToSet.setRole(oUsuarioEntityFromDataBase.getRole());
            oUsuarioEntityToSet.setPassword("f295e358ac82ac23ffe6ff6f5ac94e8a6d8a455604826c64e36b29e0aa2dd4b3");
            return oUsuarioRepository.save(oUsuarioEntityToSet);
        } else if(oSesionService.isAdmin()){
            oUsuarioEntityToSet.setPassword("f295e358ac82ac23ffe6ff6f5ac94e8a6d8a455604826c64e36b29e0aa2dd4b3");
            return oUsuarioRepository.save(oUsuarioEntityToSet);
        } else {
            oUsuarioEntityToSet.setNombre("Nombre no modificado");
            oUsuarioEntityToSet.setApellidos("Apellidos no modificados");
            oUsuarioEntityToSet.setFecha_nacimiento(LocalDate.of(1, Month.MAY, 1337)); 
            oUsuarioEntityToSet.setRole(oUsuarioEntityFromDataBase.getRole());
            oUsuarioEntityToSet.setDireccion("Calle interrogante");
            return oUsuarioEntityToSet;
        }
    }

    public Long delete(Long id){
        oSesionService.onlyAdmins();
        oUsuarioRepository.deleteById(id);
        return id;
    }
}
