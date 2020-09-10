package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea text_song;

    @FXML
    private Button btn_MySQL;

    @FXML
    private TextField text_songName;

    String textSongName;
    String textSong;

    @FXML
    void initialize() {

        DB_MySQL db = new DB_MySQL();
        btn_MySQL.setOnAction(event -> {
            this.textSongName = text_songName.getText();
            this.textSong = text_song.getText();
            if (this.textSong != "" && this.textSongName != "") {
                try {
                    db.addToTable(textSongName, textSong);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                text_song.setText("");
                text_songName.setText("");
                this.textSong = "";
                this.textSongName = "";
            }
        });
    }
}

