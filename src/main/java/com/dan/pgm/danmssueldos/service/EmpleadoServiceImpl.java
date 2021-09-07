package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    private static final String REST_API_EMPLEADOS_URL = "http://localhost:9000/api/empleado";

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    public EmpleadoDTO getEmpleadoById(Integer empleadoId){
        String url = REST_API_EMPLEADOS_URL + "/" + empleadoId;
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

    public List<EmpleadoDTO> getAllEmpleados(){
        String url = REST_API_EMPLEADOS_URL;
        WebClient client = WebClient.create(url);
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(() -> {
            try{
                List<EmpleadoDTO> empleadoRta= client.get()
                        .uri(url).accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToFlux(EmpleadoDTO.class)
                        .collectList()
                        .block();

                return empleadoRta;
            } catch (Exception e){
                return null;
            }
        }, throwable -> null);
    }
}
