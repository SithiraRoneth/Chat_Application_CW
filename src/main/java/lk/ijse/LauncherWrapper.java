/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :21:55
 * Project Name :Chat_Application
 * */
package lk.ijse;

import lk.ijse.Server.Server;

public class LauncherWrapper {
    public static void main(String[] args) {
        // Run server class main
        Thread serverThread = new Thread(() -> {
            try {
                Server.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        // Run Launcher main
        Launcher.main(args);
    }
}
