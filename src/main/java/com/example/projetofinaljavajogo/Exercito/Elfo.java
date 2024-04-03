package com.example.projetofinaljavajogo.Exercito;

import com.example.projetofinaljavajogo.Personagens.Personagem;

import java.util.Random;

public class Elfo extends Personagem {
    private static final String[] oponentesOdiados = { "Orque" };

    public Elfo(String nome, int vida, int armadura, int ataque) {
        super(nome, vida, armadura,ataque);
    }

    public Elfo() {
        super();
    }

    @Override
    public int calcularAtaque() {
        Random rand = new Random();
        int ataque = rand.nextInt(101);
        for (String oponente : oponentesOdiados) {
            if (oponente.equals("Orque")) {
                ataque += 10; // Aumenta o ataque em 10 unidades contra Orques
            }
        }
        return ataque;
    }
}