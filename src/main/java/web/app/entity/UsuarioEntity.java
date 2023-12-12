package web.app.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 64)
    private String nombre;

    @Size(min=3, max=128)
    private String apellidos;

    private LocalDate fecha_nacimiento;

    @Size(min=3, max=128)
    private String direccion;

    @NotNull
    @NotBlank
    @Size(min=3, max=32)
    private String nombre_usuario;

    @NotNull
    @NotBlank
    @Size(min=64, max=64)
    private String password;

    @NotNull
    @NotBlank
    private Boolean role;

    @NotNull
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<NoticiaEntity> noticias;

    @OneToMany(mappedBy = "usuario")
    private List<RespuestaEntity> respuestas;

    @OneToMany(mappedBy = "usuario")
    private List<DocumentoEntity> documentos;

    public UsuarioEntity() {
    }

    

    public UsuarioEntity(Long id, @Size(min = 3, max = 64) String nombre, @Size(min = 3, max = 128) String apellidos,
            LocalDate fecha_nacimiento, @Size(min = 3, max = 128) String direccion,
            @NotNull @NotBlank @Size(min = 3, max = 32) String nombre_usuario,
            @NotNull @NotBlank @Size(min = 64, max = 64) String password, @NotNull @NotBlank Boolean role,
            @NotNull @NotBlank String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    

    public UsuarioEntity(@Size(min = 3, max = 64) String nombre, @Size(min = 3, max = 128) String apellidos,
            LocalDate fecha_nacimiento, @Size(min = 3, max = 128) String direccion,
            @NotNull @NotBlank @Size(min = 3, max = 32) String nombre_usuario,
            @NotNull @NotBlank @Size(min = 64, max = 64) String password, @NotNull @NotBlank Boolean role,
            @NotNull @NotBlank String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.role = role;
        this.email = email;
    }



    public UsuarioEntity(@NotNull @NotBlank @Size(min = 3, max = 32) String nombre_usuario,
            @NotNull @NotBlank @Size(min = 64, max = 64) String password, @NotNull @NotBlank Boolean role,
            @NotNull @NotBlank String email) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.role = role;
        this.email = email;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellidos() {
        return apellidos;
    }



    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }



    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



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



    public Boolean getRole() {
        return role;
    }



    public void setRole(Boolean role) {
        this.role = role;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public List<NoticiaEntity> getNoticias() {
        return noticias;
    }



    public void setNoticias(List<NoticiaEntity> noticias) {
        this.noticias = noticias;
    }



    public List<RespuestaEntity> getRespuestas() {
        return respuestas;
    }



    public void setRespuestas(List<RespuestaEntity> respuestas) {
        this.respuestas = respuestas;
    }  

    

    
    
    
}
