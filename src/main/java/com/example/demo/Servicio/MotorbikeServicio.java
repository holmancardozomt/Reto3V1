/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Motorbike;
import com.example.demo.Repositorio.MotorbikeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorbikeServicio {
    @Autowired
    private MotorbikeRepositorio motorbikeRepository;
   
    public List<Motorbike> getAll() {
        return motorbikeRepository.getAll();
    }

    public Optional<Motorbike> getMotorbike(int motorbikeId) {
        return motorbikeRepository.getMotorbike(motorbikeId);
    }

    public Motorbike save(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return motorbikeRepository.save(motorbike);
        } else {
            Optional<Motorbike> e=motorbikeRepository.getMotorbike(motorbike.getId());
            if(e.isEmpty()){
                return motorbikeRepository.save(motorbike);
            }else{
                return motorbike;
            }
        }
    } 
}
    
