package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStart extends Application {
    private static Stage window;
    private static Scene launcher, teamBuilder, battle;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        launcher = new Scene(FXMLLoader.load(getClass().getResource("LauncherScene.fxml")),
                400, 400);
        teamBuilder = new Scene(FXMLLoader.load(getClass().getResource("TeamBuilderScene.fxml")),
                400, 400);
        battle = new Scene(FXMLLoader.load(getClass().getResource("BattleScene.fxml")),
                400, 400);
        window.setTitle("Espo Arena");
        setScene("Launcher");
        window.show();
    }

    public static void setScene(String scene) {
        switch (scene) {
            case "Launcher":
                window.setScene(launcher);
                break;
            case "TeamBuilder":
                window.setScene(teamBuilder);
                break;
            case "Battle":
                window.setScene(battle);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}