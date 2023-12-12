package web.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "respuesta")
public class RespuestaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min=3, max=512)
    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "noticia_id")
    private NoticiaEntity noticia;


    public RespuestaEntity() {
    }

    public RespuestaEntity(Long id, @NotBlank @NotNull @Size(min = 3, max = 512) String respuesta,
            UsuarioEntity usuario, NoticiaEntity noticia) {
        this.id = id;
        this.respuesta = respuesta;
        this.usuario = usuario;
        this.noticia = noticia;
    }

    public RespuestaEntity(@NotBlank @NotNull @Size(min = 3, max = 512) String respuesta, UsuarioEntity usuario,
            NoticiaEntity noticia) {
        this.respuesta = respuesta;
        this.usuario = usuario;
        this.noticia = noticia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public NoticiaEntity getNoticia() {
        return noticia;
    }

    public void setNoticia(NoticiaEntity noticia) {
        this.noticia = noticia;
    }

    
    
}
