package com.conexion.petcarec.service;
import com.conexion.petcarec.modelo.*;
import com.conexion.petcarec.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private  ProductoRepository productoRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EstadopedidoRepository estadopedidoRepository;
    @Autowired
    private DetalledeventaRepository detalledeventaRepository;



    @Transactional
    public Integer saveRegistroVenta(RegistroVenta registroVenta) {
        System.out.println(registroVenta);
        Cliente cliente = clienteRepository.findById(registroVenta.getIdcliente())
                .orElseThrow(() -> new IllegalArgumentException("cliente no válido"));
        Estadopedido estadopedido = estadopedidoRepository.findById(registroVenta.getIdestado())
                .orElseThrow(() -> new IllegalArgumentException("estado no válido"));
        System.out.println(cliente);
        Venta venta = new Venta();
        venta.setIdcliente(cliente);
        venta.setIdestado(estadopedido);
        venta.setFechapedido(registroVenta.getFechapedido());
        venta.setObservaciones(registroVenta.getObservaciones());
        venta.setFormadepago(registroVenta.getFormadepago());
        ventaRepository.save(venta);
        return venta.getId();
    }
    public Detalledeventa saveDetalledeventa(RegistroDetalleVenta registrodetalledeventa) {

        Producto producto = productoRepository.findById(registrodetalledeventa.getIdproducto())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        Venta venta= ventaRepository.findById(registrodetalledeventa.getIdpedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido no válido"));
        Detalledeventa detalledeventa = new Detalledeventa();
        detalledeventa.setCantidad(registrodetalledeventa.getCantidad());
        detalledeventa.setIdproducto(producto);
        detalledeventa.setIdpedido(venta);
        return detalledeventaRepository.save(detalledeventa);
    }
    public List<Detalledeventa> getdetalleventaById(Pedido detalledeventa) {
        Venta venta= ventaRepository.findById(detalledeventa.getIdpedido())
                .orElseThrow(() -> new IllegalArgumentException("Venta no válida"));
        return detalledeventaRepository.findByidpedido(venta);
    }
    public  List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }
}
