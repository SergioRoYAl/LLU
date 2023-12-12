package web.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioBean {
    
    private String nombre_usuario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
