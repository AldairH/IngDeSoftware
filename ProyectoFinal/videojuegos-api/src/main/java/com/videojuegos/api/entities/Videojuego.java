package com.videojuegos.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 1, max = 100, message = "El título debe tener entre 1 y 100 caracteres")
    private String titulo;

    @Column(name = "genero", nullable = false, length = 50)
    @NotBlank(message = "El género no puede estar vacío")
    @Size(max = 50, message = "El género no puede exceder 50 caracteres")
    private String genero;

    @Column(name = "plataforma", nullable = false, length = 50)
    @NotBlank(message = "La plataforma no puede estar vacía")
    @Size(max = 50, message = "La plataforma no puede exceder 50 caracteres")
    private String plataforma;

    @Column(name = "desarrollador", length = 80)
    @Size(max = 80, message = "El desarrollador no puede exceder 80 caracteres")
    private String desarrollador;

    @Column(name = "fecha_lanzamiento")
    @Past(message = "La fecha de lanzamiento debe ser anterior a hoy")
    private LocalDate fechaLanzamiento;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @DecimalMax(value = "9999.99", message = "El precio no puede exceder 9999.99")
    private BigDecimal precio;

    @Column(name = "clasificacion", length = 10)
    @Pattern(regexp = "^(E|T|M|AO|RP|EC)$",
            message = "La clasificación debe ser: E, T, M, AO, RP o EC")
    private String clasificacion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;

    @Column(name = "url_portada", length = 250)
    @Size(max = 250, message = "La URL de la portada no puede exceder 250 caracteres")
    private String urlPortada;

    // Constructores
    public Videojuego() {
    }

    public Videojuego(String titulo, String genero, String plataforma,
                      String desarrollador, LocalDate fechaLanzamiento,
                      BigDecimal precio, String clasificacion,
                      String descripcion, String urlPortada) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.desarrollador = desarrollador;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.urlPortada = urlPortada;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(genero, that.genero) &&
                Objects.equals(plataforma, that.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, genero, plataforma);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", precio=" + precio +
                ", clasificacion='" + clasificacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlPortada='" + urlPortada + '\'' +
                '}';
    }
}
