package web.app.entity;

import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detallepedido")
public class DetallePedidoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_documento")
    private DocumentoEntity documento;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @NotNull
    @Digits(integer=10, fraction=0)
    private Integer cantidad;

    @NotNull
    @Digits(integer=10, fraction=0)
    private Double precio; //Precio en euros

    public DetallePedidoEntity() {
    }

    public DetallePedidoEntity(Long id, DocumentoEntity documento, ProductoEntity producto, Integer cantidad, Double precio) {
        this.id = id;
        this.documento = documento;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public DetallePedidoEntity(DocumentoEntity documento, ProductoEntity producto, Integer cantidad, Double precio) {
        this.documento = documento;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentoEntity getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoEntity documento) {
        this.documento = documento;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    
}
