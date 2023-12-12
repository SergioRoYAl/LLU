package web.app.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min=3, max=128)
    private String nombre;

    @Size(min = 3, max = 1024)
    private String descripcion;

    @Size(min = 3, max = 64)
    private String tamanyo;

    @Size(min = 3, max = 128)
    private String materiales;

    @DateTimeFormat
    private LocalDate fecha_creacion;

    @Size(min = 3, max = 64)
    private String color;

    @NotNull
    @NotBlank
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double precio; //Precio en euros
    
    public ProductoEntity() {
    }

    public ProductoEntity(Long id, @NotNull @NotBlank @Size(min = 3, max = 128) String nombre,
            @Size(min = 3, max = 1024) String descripcion, @Size(min = 3, max = 64) String tamanyo,
            @Size(min = 3, max = 128) String materiales, LocalDate fecha_creacion,
            @Size(min = 3, max = 64) String color, @NotNull @NotBlank Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanyo = tamanyo;
        this.materiales = materiales;
        this.fecha_creacion = fecha_creacion;
        this.color = color;
        this.precio = precio;
    }

    public ProductoEntity(@NotNull @NotBlank @Size(min = 3, max = 128) String nombre,
            @Size(min = 3, max = 1024) String descripcion, @Size(min = 3, max = 64) String tamanyo,
            @Size(min = 3, max = 128) String materiales, LocalDate fecha_creacion,
            @Size(min = 3, max = 64) String color, @NotNull @NotBlank Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanyo = tamanyo;
        this.materiales = materiales;
        this.fecha_creacion = fecha_creacion;
        this.color = color;
        this.precio = precio;
    }

    public ProductoEntity(@NotNull @NotBlank @Size(min = 3, max = 128) String nombre,
            @Size(min = 3, max = 1024) String descripcion, @Size(min = 3, max = 64) String tamanyo,
            @Size(min = 3, max = 128) String materiales, @Size(min = 3, max = 64) String color,
            @NotNull @NotBlank Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanyo = tamanyo;
        this.materiales = materiales;
        this.color = color;
        this.precio = precio;
    }

    public ProductoEntity(Long id, @NotNull @NotBlank @Size(min = 3, max = 128) String nombre,
            @Size(min = 3, max = 64) String color, @NotNull @NotBlank Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }

    public ProductoEntity(@NotNull @NotBlank @Size(min = 3, max = 128) String nombre,
            @Size(min = 3, max = 64) String color, @NotNull @NotBlank Double precio) {
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    
}
