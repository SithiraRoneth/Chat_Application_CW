/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :23:52
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatController {
    @FXML
    private Label lblName;
    @FXML
    private AnchorPane root;
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(){
        String name = String.valueOf(LoginController.user);
        lblName.setText(name);

        try {
            socket = new Socket("localhost",3000);
            System.out.println("Socket connected to server");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
