package com.example.projetofinaljavajogo.Exercito;

import com.example.projetofinaljavajogo.Personagens.Personagem;

import java.util.Random;

public class Besta extends Personagem {
    public Besta(String nome, int vida, int armadura,int ataque) {
        super(nome, vida, armadura,ataque);
    }

    @Override
    public int calcularAtaque() {
        Random rand = new Random();
        return rand.nextInt(91);
    }
}