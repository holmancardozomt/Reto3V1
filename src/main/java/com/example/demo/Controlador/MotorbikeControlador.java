/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Motorbike;
import com.example.demo.Servicio.MotorbikeServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Motorbike")

public class MotorbikeControlador {
    @Autowired
    private MotorbikeServicio motorbikeService;
    @GetMapping("/all")
    public List<Motorbike> getMotorbikes(){
        return motorbikeService.getAll();      
}
    
    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbike(@PathVariable("id") int motorbikeId) {
        return motorbikeService.getMotorbike(motorbikeId);
    }
    
@PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike) {
        return motorbikeService.save(motorbike);
    }
}
