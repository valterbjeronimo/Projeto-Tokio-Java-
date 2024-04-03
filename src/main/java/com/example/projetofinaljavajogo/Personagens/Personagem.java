package com.example.projetofinaljavajogo.Personagens;




public abstract class Personagem {
    private String nome;
    private int vida;
    private int armadura;

    private int ataque;

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Personagem(String nome, int vida, int armadura,int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.armadura = armadura;
        this.ataque = ataque;
    }

    public Personagem() {

    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getArmadura() {
        return armadura;
    }

    public abstract int calcularAtaque();

    public void sofrerDano(int dano) {
        if (dano > 0) {
            vida -= dano;
            if (vida < 0) {
                vida = 0;
            }
            System.out.println(nome + " sofreu " + dano + " de dano. Vida restante: " + vida);
        } else {
            System.out.println(nome + " conseguiu se esquivar do ataque.");
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}
