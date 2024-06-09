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
    @Autowired
    private RazaRepository razaRepository;
    @Autowired
    private CuidadoRepository cuidadoRepository;
    @Autowired
    private FichaRepository fichaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

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
    public List<Categoriaproducto> getAllCategoria() {
        return categoriaRepository.findAll();
    }
    public  List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

}
