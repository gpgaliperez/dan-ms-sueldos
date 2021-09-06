package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.database.VentaRepository;
import com.dan.pgm.danmssueldos.dto.DetallePedidoDTO;
import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.dto.PedidoDTO;
import com.dan.pgm.danmssueldos.dto.VentaDTO;
import com.dan.pgm.danmssueldos.model.Empleado;
import com.dan.pgm.danmssueldos.model.Venta;
import com.dan.pgm.danmssueldos.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private static final String REST_API_USUARIOS_URL = "http://localhost:9000/api/usuarios/";

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    VentaRepository ventaRepository;

    @Override
    public VentaDTO crearVenta(PedidoDTO pedidoDTO, Integer empleadoId) {

        EmpleadoDTO empleadoObtenido = this.getEmpleadoById(empleadoId);

        if(empleadoObtenido == null){
            throw new RuntimeException("No se encontre un empleado con el id: " + empleadoId);
        }else{
            Venta nuevaVenta = new Venta();
            nuevaVenta.setEmpleado(new Empleado(empleadoObtenido.getId(), empleadoObtenido.getNombre()));

            Double montoTotal = 0.0;

            for(DetallePedidoDTO dp: pedidoDTO.getDetalle()){
                montoTotal+= dp.getCantidad() * dp.getPrecio();
            }
            nuevaVenta.setMontoTotal(montoTotal);
            nuevaVenta.setFechaVenta(pedidoDTO.getFechaPedido());
            ventaRepository.save(nuevaVenta);

            return new VentaDTO(empleadoObtenido, nuevaVenta.getMontoTotal(), nuevaVenta.getFechaVenta(), pedidoDTO.getEstado(), pedidoDTO.getIdObra() );
        }

    }

    public List<Venta> obtenerVentas(){
        return ventaRepository.findAll();
    }

    public List<Venta> obtenerByIdEmpleado(Integer empleadoId){
        List<Venta> listaVentas = obtenerVentas().stream().filter( venta -> venta.getEmpleado().getId() == empleadoId ).collect(Collectors.toList());
        return listaVentas;
    }



    public EmpleadoDTO getEmpleadoById(Integer empleadoId){
        String url = REST_API_USUARIOS_URL + empleadoId;
        WebClient client = WebClient.create(url);
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(() -> {
            try{
                EmpleadoDTO empleadoRta= client.get()
                        .uri(url).accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(EmpleadoDTO.class)
                        .block();
                return empleadoRta;

            } catch (Exception e){
                return null;
            }
        }, throwable -> null);
    }

}
