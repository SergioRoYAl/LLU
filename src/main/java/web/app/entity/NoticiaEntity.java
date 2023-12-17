package web.app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "noticia")
public class NoticiaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min=3, max=256)
    private String titulo;

    @NotNull
    @NotBlank
    @Size(min=3, max = 4192)
    private String descripción;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "noticia")
    private List<RespuestaEntity> respuestas;

    public NoticiaEntity() {
    }

    public NoticiaEntity(Long id, @NotNull @NotBlank @Size(min = 3, max = 256) String titulo,
            @NotNull @NotBlank @Size(min = 3, max = 4192) String descripción, UsuarioEntity usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripción = descripción;
        this.usuario = usuario;
    }

    public NoticiaEntity(@NotNull @NotBlank @Size(min = 3, max = 256) String titulo,
            @NotNull @NotBlank @Size(min = 3, max = 4192) String descripción, UsuarioEntity usuario) {
        this.titulo = titulo;
        this.descripción = descripción;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<RespuestaEntity> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaEntity> respuestas) {
        this.respuestas = respuestas;
    }

    
}
