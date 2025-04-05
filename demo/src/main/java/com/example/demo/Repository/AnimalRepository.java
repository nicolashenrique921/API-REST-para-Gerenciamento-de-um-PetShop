package com.example.demo.Repository;

import com.example.demo.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByClienteId(Long clienteId);
}
