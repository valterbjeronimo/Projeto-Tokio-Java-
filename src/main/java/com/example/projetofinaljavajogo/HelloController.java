package com.example.projetofinaljavajogo;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.example.projetofinaljavajogo.Exercito.*;

import com.example.projetofinaljavajogo.JogoSenhorDosAneis.JogoSenhorDosAneis;


import com.example.projetofinaljavajogo.Personagens.Personagem;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.projetofinaljavajogo.JogoSenhorDosAneis.JogoSenhorDosAneis.*;

public class HelloController {




    @FXML
    public void proximoHeroi() {
        selecionarProximoHeroi(null);
    }
    @FXML
    private void selecionarProximoHeroi (ActionEvent event) {
       tableviewHeroi.getSelectionModel().selectNext();


    }

    @FXML
    public void proximoAnteriorHeroi() {
        selecionarProximo(null);
    }
    @FXML
    private void selecionarAnteriorHeroi (ActionEvent event) {
        tableviewHeroi.getSelectionModel().selectPrevious();


    }




    @FXML
    public void AnteriorBesta() {
        selecionarProximo(null);
    }
    @FXML
    private void selecionarAnteriorBesta (ActionEvent event) {
        tableViewBesta.getSelectionModel().selectPrevious();


    }

    @FXML
    public void proximobesta() {
        selecionarProximo(null);
    }
    @FXML
    private void selecionarProximo (ActionEvent event) {
        tableViewBesta.getSelectionModel().selectNext();


    }



    @FXML
    private TableView<Personagem> tableViewBesta;
    @FXML
    private TableColumn<Personagem,Integer> colunaVidaBesta;



    @FXML
    private TableColumn<Personagem, String> colunaNomeBesta;


    @FXML
    private TableColumn<Personagem,Integer> colunaAtaqueBesta;


    @FXML
    private TableColumn<Personagem,Integer> colunaArmaduraBesta;


    @FXML
    private TableColumn<?, ?> colunaArmaduraHeroi;

    @FXML
    private TableColumn<?, ?> colunaAtaqueHeroi;

    @FXML
    private TableColumn<Personagem, Integer> colunaNomeHeroi;

    @FXML
    private TableColumn<?, ?> colunaTipoHeroi;

    @FXML
    private TableColumn<Personagem, String> colunaVidaHeroi;

    @FXML
    private TableView<Personagem> tableviewHeroi;

    private List<Personagem> personagems =new ArrayList<>();
    private List<Personagem> personagemsBestas =new ArrayList<>();


    @FXML
    private TextField textArmaduraBesta;

    @FXML
    private TextField textNomeBesta;

    @FXML
    private TextField textVidaBesta;

    @FXML
    private TextField textAtaqueBesta;

    @FXML
    private TextField textAtaqueHeroi;





    @FXML
    private Label welcomeText;


    @FXML
    private TextField textArmaduraHeroi;

    @FXML
    private TextField textNomeHeroi;

    @FXML
    private TextField textVidaHeroi;

    @FXML
    private Button SimularBtn;

    @FXML
    private Button adicionarBestaBtn;

    @FXML
    private Button adicionarHeroiBnt;

    private StringProperty selectedItemHeroi = new SimpleStringProperty("Lista de Herois");

    private StringProperty selectedItemBesta = new SimpleStringProperty("Lista de Bestas");


    @FXML
    public void onSimularButtonClickBesta() {
        deleteBesta(); // Chamando o método de exclusão ao clicar no botão de simulação
        // Adicione aqui a lógica de simulação, se necessário
    }


    @FXML
    public void deleteBesta() {
        Personagem selectedBesta = tableViewBesta.getSelectionModel().getSelectedItem();
        if (selectedBesta != null) {
            personagemsBestas.remove(selectedBesta);
            updateTableViewBesta();

        }
    }
    @FXML
    public void deleteHeroi() {
        Personagem selectedHeroi = tableviewHeroi.getSelectionModel().getSelectedItem();
        if (selectedHeroi != null) {
            personagems.remove(selectedHeroi);
            updateTableView();
        }
    }

    // Outros métodos da classe...

    @FXML
    public void onSimularButtonClick() {
        deleteHeroi(); // Chamando o método de exclusão ao clicar no botão de simulação
        // Adicione aqui a lógica de simulação, se necessário
    }


    @FXML
    private void simularBatalha() {
        // Criar uma nova lista local para os personagens da batalha
        List<Personagem> personagens = new ArrayList<>();

        // Adicionar personagens da lista 'personagems'
        personagens.addAll(personagems);

        // Adicionar personagens da lista 'personagemsBestas'
        personagens.addAll(personagemsBestas);

        // Converter a lista de personagens para um array
        Personagem[] personagensArray = personagens.toArray(new Personagem[0]);

        // Chamar o método de simulação de batalha
        JogoSenhorDosAneis.simularBatalha(personagensArray);



       /* String infoTurno = "Turno " ;
        adicionarTurnoBatalha(infoTurno);*/
    }





    @FXML
    protected void onHelloButtonClick() {
        try {
            String nome = this.textNomeHeroi.getText();
            Integer vida = Integer.parseInt(this.textVidaHeroi.getText());
            Integer armadura = Integer.parseInt(this.textArmaduraHeroi.getText());
            Integer ataque = Integer.parseInt(this.textAtaqueHeroi.getText());

            Personagem personagem = new Heroi(nome, vida, armadura,ataque);
            personagems.add(personagem);

            // Verifica se a lista de personagens não está vazia antes de atualizar a TableView
            if (!personagems.isEmpty()) {
                updateTableView();
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    protected void onHelloButtonClickBesta() {
        try {
            String nome = this.textNomeBesta.getText();
            Integer vida = Integer.parseInt(this.textVidaBesta.getText());
            Integer armadura = Integer.parseInt(this.textArmaduraBesta.getText());
            Integer ataque = Integer.parseInt(this.textAtaqueBesta.getText());

            Personagem personagem = new Besta(nome, vida, armadura,ataque);
            personagemsBestas.add(personagem);

            // Verifica se a lista de personagens não está vazia antes de atualizar a TableView
            if (!personagemsBestas.isEmpty()) {
                updateTableViewBesta();
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();

        }
    }



    private void updateTableView() {
        // Crie uma lista observável a partir da sua lista de personagens
        ObservableList<Personagem> observablePersonagens = FXCollections.observableArrayList(personagems);

        // Associe a lista observável à tabela
        tableviewHeroi.setItems(observablePersonagens);


        // Atualize as colunas da tabela para exibir os dados corretamente
        colunaNomeHeroi.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaVidaHeroi.setCellValueFactory(new PropertyValueFactory<>("vida"));
        colunaArmaduraHeroi.setCellValueFactory(new PropertyValueFactory<>("armadura"));
        colunaAtaqueHeroi.setCellValueFactory(new PropertyValueFactory<>("ataque")); // Se a classe Personagem tiver um método 'getAtaque()'
    }



    private void updateTableViewBesta() {
        // Crie uma lista observável a partir da sua lista de personagens
        ObservableList<Personagem> observablePersonagens = FXCollections.observableArrayList(personagemsBestas);

        // Associe a lista observável à tabela
        tableViewBesta.setItems(observablePersonagens);


        // Atualize as colunas da tabela para exibir os dados corretamente
        colunaNomeBesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaVidaBesta.setCellValueFactory(new PropertyValueFactory<>("vida"));
        colunaArmaduraBesta.setCellValueFactory(new PropertyValueFactory<>("armadura"));
        colunaAtaqueBesta.setCellValueFactory(new PropertyValueFactory<>("ataque")); // Se a classe Personagem tiver um método 'getAtaque()'
    }


    @FXML
    public void handleElfo() {


        setTextNomeHeroi("Elrond");
        setSelectedItemHeroi("Elfo");
        setTextArmaduraHeroi("50");
        setTextVidaHeroi("100");

        System.out.println("Você selecionou Elfo");


        if(getSelectedItemHeroi().equals("Elfo")){

            Elfo elfo = new Elfo("Legolas", 100, 50,0);

            // Chamando o método calcularAtaque() da classe Elfo
            int ataque = elfo.calcularAtaque();

            setTextAtaqueHeroi(ataque);

            // Imprimindo o resultado do ataque
            System.out.println("Ataque do Elfo: " + ataque);
        }


    }

    @FXML
    public void handleHeroi() {


        setTextNomeHeroi("Aragorn ");
        setSelectedItemHeroi("Heroi");
        setTextArmaduraHeroi("60");
        setTextVidaHeroi("100");
        System.out.println("Você selecionou Aragorn");

        if(getSelectedItemHeroi().equals("Heroi")){

            Heroi heroi = new Heroi("Frodo", 100, 50,0);

            // Chamando o método calcularAtaque() Heroi
            int ataque = heroi.calcularAtaque();
            // Imprimindo o resultado do ataque

            setTextAtaqueHeroi(ataque);
            System.out.println("Ataque do Aragorn: " + ataque);
        }

    }

    @FXML
    public void handleHobbit() {
        setTextNomeHeroi("Frodo ");
        setSelectedItemHeroi("Hobbit");
        setTextArmaduraHeroi("50");
        setTextVidaHeroi("100");
        System.out.println("Você selecionou Frodo");

        if(getSelectedItemHeroi().equals("Hobbit")){

            Hobbit hobbit = new Hobbit("Frodo", 100, 50,0);

            // Chamando o método calcularAtaque() Hobbit
            int ataque = hobbit.calcularAtaque();

            setTextAtaqueHeroi(ataque);
            // Imprimindo o resultado do ataque
            System.out.println("Ataque do Frodo: " + ataque);
        }


    }

    @FXML
    public void handleBesta() {
        setSelectedItemBesta("Besta");
        setTextNomeBesta("Besta");
        setTextArmaduraBesta("50");
        setTextVidaBesta("100");


        System.out.println("Você selecionou Besta");



       if(getSelectedItemBesta().equals("Besta")){

            Besta besta = new Besta("Besta", 100, 50,0);

            // Chamando o método calcularAtaque() da Besta
            int ataque = besta.calcularAtaque();

           setTextAtaqueBesta(ataque);

            // Imprimindo o resultado do ataque
            System.out.println("Ataque Besta: " + ataque);
        }




    }

    @FXML
    public void handleOrque() {
        setSelectedItemBesta("Orque");
        setTextNomeBesta("Orque");
        setTextArmaduraBesta("50");
        setTextVidaBesta("100");
        System.out.println("Você selecionou Orque");

        if(getSelectedItemBesta().equals("Orque")){

            Orque orque = new Orque("Orque", 100, 50,0);

            // Chamando o método calcularAtaque() da Orque
            int ataque = orque.calcularAtaque();

            setTextAtaqueBesta(ataque);

            // Imprimindo o resultado do ataque
            System.out.println("Ataque Orque" +
                    "" +
                    ": " + ataque);
        }
    }

    public void test(){

    }

    public String getSelectedItemHeroi() {
        return selectedItemHeroi.get();
    }

    public StringProperty selectedItemHeroiProperty() {
        return selectedItemHeroi;
    }

    public void setSelectedItemHeroi(String selectedItem) {
        this.selectedItemHeroi.set(selectedItem);
    }

    public String getSelectedItemBesta() {
        return selectedItemBesta.get();
    }

    public StringProperty selectedItemBestaProperty() {
        return selectedItemBesta;
    }

    public void setSelectedItemBesta(String selectedItem) {
        this.selectedItemBesta.set(selectedItem);
    }

    public void setTextArmaduraHeroi(String text) {
        textArmaduraHeroi.setText(text);
    }

    public void getTextArmaduraHeroi(String text) {
        textArmaduraHeroi.getText();
    }

    public void setTextNomeHeroi(String text) {
        textNomeHeroi.setText(text);
    }

    public void getTextNomeHeroi(String text) {
        textNomeHeroi.getText();
    }

    public void setTextVidaHeroi(String text) {
        textVidaHeroi.setText(text);
    }

    public void getTextVidaHeroi(String text) {
        textVidaHeroi.getText();
    }

    @FXML
    public void setTextNomeBesta(String text) {
        textNomeBesta.setText(text);
    }

    @FXML
    public void setTextArmaduraBesta(String text) {
        textArmaduraBesta.setText(text);
    }

    @FXML
    public void setTextVidaBesta(String text) {
        textVidaBesta.setText(text);
    }

    @FXML
    public void setTextAtaqueBesta(int ataque) {
        textAtaqueBesta.setText(String.valueOf(ataque));
    }

    @FXML
    public void setTextAtaqueHeroi(int ataque) {
        textAtaqueHeroi.setText(String.valueOf(ataque));
    }





   /* @FXML
    private ListView<String> listViewTurnos;

    private ObservableList<String> turnos = FXCollections.observableArrayList();

    // Outros métodos do controlador...

    public void adicionarTurnoBatalha(String turno) {
        turnos.add(turno);
        listViewTurnos.setItems(turnos);
    }*/





   /* public String lutar(Personagem atacante, Personagem defensor) {
        int ataque = atacante.calcularAtaque();
        int dano = calcularDano(ataque, defensor.getArmadura());

        String infoLuta = "Luta entre " + atacante.getNome() + " e " + defensor.getNome() + "\n" +
                atacante.getNome() + " ataca com " + ataque + "\n";
        defensor.sofrerDano(dano);
        if (!defensor.estaVivo()) {
            infoLuta += defensor.getNome() + " foi derrotado.\n";
        } else {
            infoLuta += defensor.getNome() + " sofreu " + dano + " de dano. Vida restante: " + defensor.getVida() + "\n";
        }
        return infoLuta;
    }*/



    @FXML
    private TextArea consoleTextArea;

    public void initialize() {
        redirectSystemStreams();
    }

    private void updateTextArea(final String text) {
        consoleTextArea.appendText(text + "\n");
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }




}


