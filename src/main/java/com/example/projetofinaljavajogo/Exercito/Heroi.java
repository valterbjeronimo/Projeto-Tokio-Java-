package com.example.projetofinaljavajogo.Exercito;

import com.example.projetofinaljavajogo.Personagens.Personagem;

import java.util.Random;

public class Heroi extends Personagem {
    public Heroi(String nome, int vida, int armadura,int ataque) {
        super(nome, vida, armadura,ataque);
    }

    @Override
    public int calcularAtaque() {
        Random rand = new Random();
        int dado1 = rand.nextInt(101);
        int dado2 = rand.nextInt(101);
        return Math.max(dado1, dado2);
    }
}