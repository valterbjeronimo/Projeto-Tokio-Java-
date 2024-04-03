package com.example.projetofinaljavajogo.JogoSenhorDosAneis;

import com.example.projetofinaljavajogo.Personagens.Personagem;

public class JogoSenhorDosAneis {

    public static void simularBatalha(Personagem... personagens) {
        int rodada = 1;

        while (rodada <= 3 && existeSobrevivente(personagens)) {
            System.out.println("Turno " + rodada + ":");

            for (int i = 0; i < personagens.length - 1; i++) {
                if (personagens[i].estaVivo() && personagens[i + 1].estaVivo()) {
                    lutar(personagens[i], personagens[i + 1]);
                }
            }

            rodada++;
        }

        determinarVencedor(personagens);
    }



  /*  public static void simularBatalha(Personagem... personagens) {
        int rodada = 1;

        while (rodada <= 3 && existeSobrevivente(personagens)) {
            String infoTurno = "Turno " + rodada + ":\n";

            for (int i = 0; i < personagens.length - 1; i++) {
                if (personagens[i].estaVivo() && personagens[i + 1].estaVivo()) {
                    infoTurno += lutar(personagens[i], personagens[i + 1]) + "\n";
                }
            }

            adicionarTurnoBatalha(infoTurno);
            rodada++;
        }

    }*/


    public static void lutar(Personagem atacante, Personagem defensor) {
        int ataque = atacante.calcularAtaque();
        int dano = calcularDano(ataque, defensor.getArmadura());

        System.out.println("Luta entre " + atacante.getNome() + " e " + defensor.getNome());
        System.out.println(atacante.getNome() + " ataca com " + ataque);
        defensor.sofrerDano(dano);
        System.out.println();

        Personagem temp = atacante;
        atacante = defensor;
        defensor = temp;
    }

    public static int calcularDano(int ataque, int armadura) {
        int dano = Math.max(0, ataque - armadura);
        return dano;
    }

    public static boolean existeSobrevivente(Personagem... personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    public static void determinarVencedor(Personagem... personagens) {
        int vivosHerois = contarVivos(personagens[0], personagens[1], personagens[2]);
        int vivosBestas = contarVivos(personagens[3], personagens[4]);

        if (vivosHerois > vivosBestas) {
            System.out.println("Os Heróis venceram!");
        } else if (vivosBestas > vivosHerois) {
            System.out.println("As Bestas venceram!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }

    public static int contarVivos(Personagem... personagens) {
        int contagem = 0;
        for (Personagem personagem : personagens) {
            if (personagem.estaVivo()) {
                contagem++;
            }
        }
        return contagem;
    }
}

