package com.conexion.petcarec.service;
import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final ProductoRepository productoRepository;
    private VentaRepository ventaRepository;
    private ClienteRepository clienteRepository;
    private EstadopedidoRepository estadopedidoRepository;
    private DetalledeventaRepository detalledeventaRepository;

    public VentaService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public Venta saveRegistroVenta(RegistroVenta registroVenta) {
        Cliente cliente = clienteRepository.findById(registroVenta.getIdcliente())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        Estadopedido estadopedido = estadopedidoRepository.findById(registroVenta.getIdestado())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        Venta venta = new Venta();
        venta.setIdcliente(cliente);
        venta.setIdestado(estadopedido);
        venta.setFechapedido(registroVenta.getFechapedido());
        venta.setObservaciones(registroVenta.getObservaciones());
        venta.setFormadepago(registroVenta.getFormadepago());
        return ventaRepository.save(venta);
    }
    public Detalledeventa saveDetalledeventa(RegistroDetalleVenta registrodetalledeventa) {

        Producto producto = productoRepository.findById(registrodetalledeventa.getIdproducto())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        Venta venta= ventaRepository.findById(registrodetalledeventa.getIdpedido())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        Detalledeventa detalledeventa = new Detalledeventa();
        detalledeventa.setCantidad(registrodetalledeventa.getCantidad());
        detalledeventa.setIdproducto(producto);
        detalledeventa.setIdpedido(venta);
        return detalledeventaRepository.save(detalledeventa);
    }
    public List<Detalledeventa> getdetalleventaById(RegistroDetalleVenta detalledeventa) {
        Venta venta= ventaRepository.findById(detalledeventa.getIdpedido())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        return detalledeventaRepository.findByIdPedido(venta.getId());
    }
    public  List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }
}
