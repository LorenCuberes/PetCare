package com.conexion.petcarec.service;


import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;


    @Transactional
    public Producto registrarProducto(RegistroProducto registroProducto) {


        //se busca la categoria por id
        Categoriaproducto categoria = categoriaRepository.findById(registroProducto.getIdcategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));


        // Crear la entidad producto
        Producto producto = new Producto();
        producto.setNombre(registroProducto.getNombre());
        producto.setPrecio(BigDecimal.valueOf(registroProducto.getPrecio()));
        producto.setStock(registroProducto.getStock());
        producto.setCodigoproducto(registroProducto.getCodigoproducto());
        producto.setIdcategoria(categoria);


        // Guardar la entidad producto
        return productoRepository.save(producto);

    }
    public List<Categoriaproducto> getAllCategoriaproducto() {
        return categoriaRepository.findAll();
    }
    public boolean VerificarProducto(String codigoproducto) {
        Producto producto = productoRepository.findBycodigoproducto(codigoproducto);
        if ( producto == null) {
            return true; // Autenticación exitosa
        }
        return false; // Autenticación fallida
    }

    public  List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Transactional
    public Producto actualizarStock(Integer idproducto, int cantidad) {

        //Producto producto = productoRepository.findByid(idproducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + idproducto));
        // Actualizar el stock
        producto.setStock(producto.getStock() - cantidad);

        // Guardar los cambios en la base de datos
        return productoRepository.save(producto);

    }

}
