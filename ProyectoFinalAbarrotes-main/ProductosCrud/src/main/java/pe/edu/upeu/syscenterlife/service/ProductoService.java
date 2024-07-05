package pe.edu.upeu.syscenterlife.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Producto;
import pe.edu.upeu.syscenterlife.repositorio.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public boolean agregarProducto(Producto producto) {
        try {
            producto.setTotalGanancias(producto.getCantidad() * producto.getPrecio());
            productoRepository.save(producto);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto buscarProducto(String codigo) {
        return productoRepository.findById(codigo).orElse(null);
    }


    public Producto actualizarProducto(Producto productoActualizado) {
        productoActualizado.setTotalGanancias(productoActualizado.getCantidad() * productoActualizado.getPrecio());
        return productoRepository.save(productoActualizado);
    }

    public void eliminarProducto(String codigo) {
        productoRepository.deleteById(codigo);
    }
}
