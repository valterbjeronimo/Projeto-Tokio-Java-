module com.example.projetofinaljavajogo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetofinaljavajogo to javafx.fxml;
    exports com.example.projetofinaljavajogo;
    opens com.example.projetofinaljavajogo.Personagens to javafx.base;
}