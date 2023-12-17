package web.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "documento")
public class DocumentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
    
    @NotNull
    @NotBlank
    private LocalDate fecha_pedido;

    public DocumentoEntity(Long id, UsuarioEntity usuario, @NotNull @NotBlank LocalDate fecha_pedido) {
        this.id = id;
        this.usuario = usuario;
        this.fecha_pedido = fecha_pedido;
    }

    public DocumentoEntity(UsuarioEntity usuario, @NotNull @NotBlank LocalDate fecha_pedido) {
        this.usuario = usuario;
        this.fecha_pedido = fecha_pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    
}
