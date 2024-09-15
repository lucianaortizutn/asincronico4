package org.example;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Audited

@Entity
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int cantidad;
    private String denominacion;
    private int precio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria",
        joinColumns = @JoinColumn(name = "articulo_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.categorias = new HashSet<>();
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        if (categorias == null) {
            this.categorias = new HashSet<>(); // Asegurar no asignar null
        } else {
            this.categorias = categorias;
        }
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", denominacion='" + denominacion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
