package mainApp;

import command.Command;
import controller.SimpleCommandController;
import menu_command.HelloCommand;

public class MainMenu {

    private final SimpleCommandController commandController = new SimpleCommandController();

    public void start() {
        Command command = new HelloCommand();
        while (true) {
            command = commandController.runCommand(command);
        }
    }
}
