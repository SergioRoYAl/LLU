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
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @JoinColumn(name = "foto")
    private String foto;

    @NotNull
    @JoinColumn(name = "visible")
    private boolean visible;

    @OneToMany(mappedBy = "noticia", fetch = jakarta.persistence.FetchType.LAZY)
    private List<RespuestaEntity> respuestas;

    public NoticiaEntity() {
        respuestas = new java.util.ArrayList<>();
    }

    public NoticiaEntity(@NotNull @NotBlank @Size(min = 3, max = 256) String titulo,
            @NotNull @NotBlank @Size(min = 3, max = 4192) String descripcion, UsuarioEntity usuario, String foto,
            @NotNull boolean visible) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.foto = foto;
        this.visible = visible;
    }

    

    public NoticiaEntity(@NotNull @NotBlank @Size(min = 3, max = 256) String titulo,
            @NotNull @NotBlank @Size(min = 3, max = 4192) String descripcion, UsuarioEntity usuario,
            @NotNull boolean visible) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int getRespuestas(){
        return respuestas.size();
    }

    
}
