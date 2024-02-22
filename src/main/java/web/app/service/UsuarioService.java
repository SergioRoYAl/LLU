package web.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<UsuarioEntity> getPage(Pageable oPageable, String filter){
        oSesionService.onlyAdmins();
        Page<UsuarioEntity> page;

        if (filter == null || filter.isEmpty() || filter.trim().isEmpty()) {
            page = oUsuarioRepository.findAll(oPageable);
        } else {
            page = oUsuarioRepository.findByUserByNameOrSurnameOrLastnameContainingIgnoreCase(
                    filter, filter, filter, filter, oPageable);
        }
        return page;
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
    
    public Long update(UsuarioEntity oUsuarioEntityToSet){
        UsuarioEntity oUsuarioEntityFromDataBase = this.get(oUsuarioEntityToSet.getId());
        oSesionService.onlyAdminsOrUsersWithItsOwnData(oUsuarioEntityFromDataBase.getId());
        if(oSesionService.isUser()){
            oUsuarioEntityToSet.setRole(oUsuarioEntityFromDataBase.getRole());
            oUsuarioEntityToSet.setPassword(oUsuarioEntityFromDataBase.getPassword());
            return oUsuarioRepository.save(oUsuarioEntityToSet).getId();
        } else if(oSesionService.isAdmin()){
            oUsuarioEntityToSet.setRole(oUsuarioEntityFromDataBase.getRole());  
            oUsuarioEntityToSet.setPassword(oUsuarioEntityFromDataBase.getPassword());
            return oUsuarioRepository.save(oUsuarioEntityToSet).getId();
            
        } else {
            return oUsuarioEntityToSet.getId();
        }
    }

    public Long delete(Long id){
        oSesionService.onlyAdmins();
        oUsuarioRepository.deleteById(id);
        return id;
    }

    public UsuarioEntity getOneRandom(){
        oSesionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * oUsuarioRepository.count()), 1);
        return oUsuarioRepository.findAll(oPageable).getContent().get(0);
    }
}
