package com.example.projetofinaljavajogo.Exercito;

import com.example.projetofinaljavajogo.Personagens.Personagem;

import java.util.Random;

public class Orque extends Personagem {
    private static final double REDUCAO_ARMADURA = 0.10; // Redução de 10% na armadura do oponente

    public Orque(String nome, int vida, int armadura,int ataque) {
        super(nome, vida, armadura,ataque);
    }

    @Override
    public int calcularAtaque() {
        Random rand = new Random();
        return rand.nextInt(101);
    }

    @Override
    public void sofrerDano(int dano) {
        super.sofrerDano(dano);
        if (dano > 0) {
            // Reduz a armadura do oponente em 10% para este turno
            int novaArmadura = (int) (getArmadura() * (1 - REDUCAO_ARMADURA));
            setArmadura(novaArmadura);
        }
    }

    private void setArmadura(int novaArmadura) {

    }
}