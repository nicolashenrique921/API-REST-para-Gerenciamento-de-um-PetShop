package com.example.demo.Service;


import com.example.demo.Model.Animal;
import com.example.demo.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
    }

    public List<Animal> listarPorCliente(Long clienteId) {
        return animalRepository.findByClienteId(clienteId);
    }

    public Animal atualizar(Long id, Animal animalAtualizado) {
        Animal animalExistente = buscarPorId(id);
    
        animalExistente.setNome(animalAtualizado.getNome());
        animalExistente.setEspecie(animalAtualizado.getEspecie());
        animalExistente.setIdade(animalAtualizado.getIdade());
        animalExistente.setCor(animalAtualizado.getCor());
        animalExistente.setObservacao(animalAtualizado.getObservacao());
        animalExistente.setCliente(animalAtualizado.getCliente());
    
        return animalRepository.save(animalExistente);
    }
    

    public void deletar(Long id) {
        Animal animal = buscarPorId(id);
        animalRepository.delete(animal);
    }
}


