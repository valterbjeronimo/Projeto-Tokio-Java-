package com.example.projetofinaljavajogo;

import com.example.projetofinaljavajogo.Personagens.Personagem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Jogo da Terra Media !");
        stage.setScene(scene);
        stage.show();
        TableView<Personagem> tableView = new TableView<>();
    }

    public static void main(String[] args) {
        launch();
        //JogoSenhorDosAneis.simularBatalha();
    }
}

