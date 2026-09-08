package com.template;

import com.template.factory.ControllerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));

        ControllerFactory factory = new ControllerFactory();
        loader.setControllerFactory(factory::criarController);

        Scene scene = new Scene(loader.load());

        stage.setTitle("Cadastro de Princesa da Disney");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}