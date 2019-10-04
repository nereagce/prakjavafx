package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrakJavafx extends Application {

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Bildumak");

        ComboBox comboBox = new ComboBox();

        List<String> bildumak = List.of("abereak", "loreak", "frutak");

        ObservableList<Bilduma> bildumaList = FXCollections.observableArrayList();

        bildumak.forEach((elem) -> {
            bildumaList.add(new Bilduma(elem));
        });

        comboBox.setItems(bildumaList);
        Map<String, List<Argazki>> bildumaMap = new HashMap<>();

        bildumaMap.put("abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")
        ));

        bildumaMap.put("loreak", List.of(
                new Argazki("Bitxilorea", "ladare1.jpeg"),
                new Argazki("Arrosa", "landare2.jpeg"),
                new Argazki("Eguzkilorea", "landare3.png")
        ));

        bildumaMap.put("frutak", List.of(
                new Argazki("Marrubia", "marrubia.jpeg"),
                new Argazki("Sagarra", "sagarra.jpeg"),
                new Argazki("Laranja", "laranja.png")
        ));

        ListView listViewOfArgazki = new ListView<>();
        comboBox.setOnAction(e -> {
            ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
            argazkiList.addAll(bildumaMap.get(comboBox.getValue().toString()));
            listViewOfArgazki.setItems(argazkiList);
        });
        ImageView imageView=new ImageView();
        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().toString();

            try {
                FileInputStream input = new FileInputStream("/opt/prakjavafx/src/main/resources/"+fitx);
                Image image = new Image(input);
                imageView.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        VBox vbox = new VBox( comboBox, listViewOfArgazki,imageView);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}