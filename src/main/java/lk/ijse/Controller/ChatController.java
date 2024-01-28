/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:52
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatController extends Thread{
    @FXML
    private AnchorPane rootNode;
    @FXML
    private AnchorPane emojiPane;
    @FXML
    private Label lblName;
    @FXML
    private VBox msgVbox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextField txtMsg;
    FileChooser fileChooser;
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    File filepath;
    String name = LoginController.user;

    public void initialize(){

        lblName.setText(name);

        try {
            socket = new Socket("localhost",3000);
            System.out.println("Socket connected to server");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);

            this.start();

            emojiPane.setVisible(false);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void hide_emoji_pane(MouseEvent event) {
        emojiPane.setVisible(false);
    }
    @FXML
    void emoji_on_action(MouseEvent event) {
        emojiPane.setVisible(true);
    }

    @FXML
    void image_on_action(MouseEvent event) {
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        this.filepath = fileChooser.showOpenDialog(stage);
        printWriter.println(this.filepath.getPath());
    }

    @FXML
    void send_on_action(MouseEvent event) {
       sendMessage();
    }

    private void sendMessage() {
        String msg = txtMsg.getText();
        if (msg != null){
            if(msg.equalsIgnoreCase("bye") || (msg.equalsIgnoreCase("exit"))) {
                System.exit(0);
            }
            appendText(msg);
            txtMsg.setText(null);
        }

    }
    public void writeMessage(String message) {
        HBox hBox = new HBox();
        hBox.setStyle("-fx-alignment: center-left;-fx-fill-height: true;-fx-min-height: 50;-fx-pref-width: 520;-fx-max-width: 520;-fx-padding: 10");
        Label messageLbl = new Label(message);
        messageLbl.setStyle("-fx-background-color:   #696969;-fx-background-radius:15;-fx-font-size: 16;-fx-font-weight: normal;-fx-text-fill: white;-fx-wrap-text: true;-fx-alignment: center-left;-fx-content-display: left;-fx-padding: 10;-fx-max-width: 350;");
        hBox.getChildren().add(messageLbl);
        Platform.runLater(() -> msgVbox.getChildren().add(hBox));

    }

    private void appendText(String msg) {
        HBox hBox = new HBox();
        hBox.setStyle("-fx-alignment: center-right; -fx-fill-height: true; -fx-min-height: 50; -fx-pref-width: 520; -fx-max-width: 520; -fx-padding: 10");

        Label messageLbl = new Label(msg);
        messageLbl.setStyle("-fx-background-color: #A52A2A; -fx-background-radius: 15; -fx-font-size: 16; -fx-font-weight: normal; -fx-text-fill: white; -fx-wrap-text: true; -fx-alignment: center-left; -fx-content-display: left; -fx-padding: 10; -fx-max-width: 350;");

        hBox.getChildren().add(messageLbl);
        msgVbox.getChildren().add(hBox);
    }


    @FXML
    void emoji1(MouseEvent mouseEvent) {
    }
    @FXML
    void emoji10(MouseEvent event) {
    }
    @FXML
    void emoji11(MouseEvent event) {

    }

    @FXML
    void emoji12(MouseEvent event) {

    }

    @FXML
    void emoji2(MouseEvent event) {

    }

    @FXML
    void emoji3(MouseEvent event) {

    }

    @FXML
    void emoji4(MouseEvent event) {

    }

    @FXML
    void emoji5(MouseEvent event) {

    }

    @FXML
    void emoji6(MouseEvent event) {

    }

    @FXML
    void emoji7(MouseEvent event) {

    }

    @FXML
    void emoji8(MouseEvent event) {

    }

    @FXML
    void emoji9(MouseEvent event) {

    }
}
