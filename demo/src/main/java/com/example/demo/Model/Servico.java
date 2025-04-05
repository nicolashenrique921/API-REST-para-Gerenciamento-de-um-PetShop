package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo; 

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer tempoDuracao; 
}

