package com.example.demo.Controller;


import com.example.demo.Model.Animal;
import com.example.demo.Service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Criar um novo animal
    @PostMapping
    public ResponseEntity<Animal> criarAnimal(@RequestBody Animal animal) {
        Animal novoAnimal = animalService.salvar(animal);
        return ResponseEntity.ok(novoAnimal);
    }

    // Buscar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
        List<Animal> animais = animalService.listarTodos();
        return ResponseEntity.ok(animais);
    }

    // Buscar um animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        Animal animal = animalService.buscarPorId(id);
        return ResponseEntity.ok(animal);
    }

    // Buscar todos os animais de um cliente específico
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Animal>> listarPorCliente(@PathVariable Long clienteId) {
        List<Animal> animais = animalService.listarPorCliente(clienteId);
        return ResponseEntity.ok(animais);
    }

    // Atualizar os dados de um animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable Long id, @RequestBody Animal animal) {
        Animal atualizado = animalService.atualizar(id, animal);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar um animal pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


