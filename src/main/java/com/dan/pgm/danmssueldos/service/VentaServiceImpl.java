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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    VentaRepository ventaRepository;

    @Override
    public VentaDTO crearVenta(PedidoDTO pedidoDTO, Integer empleadoId) {

        EmpleadoDTO empleadoObtenido = empleadoService.getEmpleadoById(empleadoId);

        if(empleadoObtenido == null){
            throw new RuntimeException("No se encontre un empleado con el id: " + empleadoId);
        }else{
            Venta nuevaVenta = new Venta();
            Empleado empleado = new Empleado(empleadoObtenido.getId(), empleadoObtenido.getNombre());
            nuevaVenta.setEmpleado(empleado.getId());

            Double montoTotal = 0.0;

            for(DetallePedidoDTO dp: pedidoDTO.getDetalle()){
                montoTotal+= dp.getCantidad() * dp.getPrecio();
            }
            nuevaVenta.setMontoTotal(montoTotal);
            nuevaVenta.setFechaVenta(LocalDate.now());
            ventaRepository.save(nuevaVenta);

            return new VentaDTO(empleadoObtenido, nuevaVenta.getMontoTotal(), nuevaVenta.getFechaVenta(), pedidoDTO.getEstado(), pedidoDTO.getIdObra() );
        }

    }

    public List<Venta> obtenerVentas(){
        return ventaRepository.findAll();
    }

    public List<Venta> obtenerVentasByEmpleado(Integer empleadoId){
        List<Venta> listaVentas = obtenerVentas().stream().filter( venta -> venta.getEmpleado() == empleadoId ).collect(Collectors.toList());
        return listaVentas;
    }


    public Long cantVentasDelMesByEmpleado(Integer empleadoId) {
        LocalDate inicioMes = LocalDate.now().minusMonths(1);
        List<Venta> ventasByEmpleado = this.obtenerVentasByEmpleado(empleadoId);
        Long cantVentasMes = ventasByEmpleado.stream()
                                    .filter(venta -> venta.getFechaVenta()
                                            .isAfter(inicioMes))
                                    .count();
        return cantVentasMes;
    }

    public List<Venta> obtenerVentasDelMes(){
        LocalDate inicioMes = LocalDate.now().minusMonths(1);
        return ventaRepository.findAllByFechaVentaAfter(inicioMes);
    }

    public EmpleadoDTO mejorVendedorDelMes(){
        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        Long maxVentas = 0L;
        EmpleadoDTO mejorVendedor = new EmpleadoDTO();

        for(EmpleadoDTO e: empleados){
            Long ventasEmpleado = this.cantVentasDelMesByEmpleado(e.getId());
            if(maxVentas <= ventasEmpleado ){
                maxVentas = ventasEmpleado;
                mejorVendedor = e;
            }
        }

        return mejorVendedor;
    }




}
