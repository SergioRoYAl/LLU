package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import web.app.bean.UsuarioBean;
import web.app.entity.UsuarioEntity;
import web.app.exception.UnauthorizedException;
import web.app.helper.JWTHelper;
import web.app.repository.UsuarioRepository;

@Service
public class SesionService {
    
    @Autowired
    UsuarioRepository oUsuarioRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    public String login(UsuarioBean oUsuarioBean){
        oUsuarioRepository.findByUsernameAndPassword(oUsuarioBean.getUsername(), oUsuarioBean.getPassword())
            .orElseThrow(() -> new RuntimeException("Usuario o contraseña incorrectos"));
        return JWTHelper.generateJWT(oUsuarioBean.getUsername());
    }

    public String getSessionUsername(){
        if (oHttpServletRequest.getAttribute("nombre_usuario") instanceof String) {
            return oHttpServletRequest.getAttribute("nombre_usuario").toString();
        } else {
            return null;
        }
    }

    public UsuarioEntity getSessionUsuario(){
        if (this.getSessionUsername() != null) {
            return oUsuarioRepository.findByUsername(this.getSessionUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        } else {
            return null;
        }   
    }

    public Boolean isSessionActive(){
        if (this.getSessionUsername() != null) {
            return oUsuarioRepository.findByUsername(this.getSessionUsername())
                .isPresent();
        } else {
            return false;
        }
    }

    public Boolean isAdmin(){
        if (this.getSessionUsername() != null) {
            UsuarioEntity oUsuarioEntity = oUsuarioRepository.findByUsername(this.getSessionUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")); 
            return Boolean.FALSE.equals(oUsuarioEntity.getRole());
        } else {
            return false;
        }
    }

    public Boolean isUser(){
        if (this.getSessionUsername() != null) {
            UsuarioEntity oUsuarioEntity = oUsuarioRepository.findByUsername(this.getSessionUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")); 
            return Boolean.TRUE.equals(oUsuarioEntity.getRole());
        } else {
            return false;
        }
    }

    public void onlyUsers(){
        if (!this.isUser()) {
            throw new RuntimeException("Acceso denegado, acesso solo para usuarios");
        }
    }

    public void onlyAdmins(){
        if (!this.isAdmin()) {
            throw new RuntimeException("Acceso denegado, acceso solo para administradores");
        }
    }

    public void onlyAdminsAndUsers(){
        if (!this.isSessionActive()) {
            throw new RuntimeException("Acceso denegado, acceso solo para administradores y usuarios");
        }
    }

    public void onlyUsersWithItsOwnData(Long id_usuario){
        if(!this.isUser()){
            throw new UnauthorizedException("Solo pueden hacerlo los usuarios");
        }
        if(!this.getSessionUsuario().getId().equals(id_usuario)){
            throw new UnauthorizedException("Solo pueden hacerlo los usuarios con sus propios datos");
        }
    }

    public void onlyAdminsOrUsersWithItsOwnData(Long id_user) {
            if (this.isSessionActive()) {
            if (!this.isAdmin()) {
                if (!this.isUser()) {
                    throw new UnauthorizedException("Solo los admins o los usuarios pueden hacer esto");
                } else {
                    if (!this.getSessionUsuario().getId().equals(id_user)) {
                        throw new UnauthorizedException("Solo los admins o los usuarios pueden hacer esto");
                    }
                }
            }
        } else {
            throw new UnauthorizedException("Solo los admins o los usuarios pueden hacer esto");
        }
    }

}
