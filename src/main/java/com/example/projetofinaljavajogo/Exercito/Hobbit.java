package com.example.projetofinaljavajogo.Exercito;

import com.example.projetofinaljavajogo.Personagens.Personagem;

import java.util.Random;

public class Hobbit extends Personagem {
    private static final String[] oponentesTemidos = { "Troll" };

    public Hobbit(String nome, int vida, int armadura,int ataque) {
        super(nome, vida, armadura,ataque);
    }

    @Override
    public int calcularAtaque() {
        Random rand = new Random();
        int ataque = rand.nextInt(101);
        for (String oponente : oponentesTemidos) {
            if (oponente.equals("Troll")) {
                ataque -= 5; // Reduz o ataque em 5 unidades contra Trolls
            }
        }
        return Math.max(0, ataque); // Garante que o ataque não seja negativo
    }
}