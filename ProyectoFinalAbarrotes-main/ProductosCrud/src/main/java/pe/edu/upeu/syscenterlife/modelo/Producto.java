package pe.edu.upeu.syscenterlife.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @Column(name = "codigo_producto")
    @Basic(optional = false)
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    @Column(name = "total_ganancias")
    private double totalGanancias = 0;

    
    
}
