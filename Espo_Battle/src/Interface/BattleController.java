package Interface;

import Mechanics.Creature;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BattleController {
    private String log = "";
    private static Creature[] party1, party2;

    @FXML
    private Button btn_move1, btn_move2, btn_move3, btn_move4, btn_move5;
    @FXML
    private TextArea txt_log;

    @FXML
    public void initialize() {
        party1 = new Creature[5];
        party2 = new Creature[5];
        for (int i = 0; i < 5; i++) {
            party1[i] = new Creature();
            party2[i] = new Creature();
        }

        Creature active1 = party1[0];
        Creature active2 = party2[0];

        btn_move1.setText(active1.getMove(0).getName());
        btn_move2.setText(active1.getMove(1).getName());
        btn_move3.setText(active1.getMove(2).getName());
        btn_move4.setText(active1.getMove(3).getName());
        btn_move5.setText(active1.getMove(4).getName());

        btn_move1.setOnAction(e -> selectMove(0));
        btn_move2.setOnAction(e -> selectMove(1));
        btn_move3.setOnAction(e -> selectMove(2));
        btn_move4.setOnAction(e -> selectMove(3));
        btn_move5.setOnAction(e -> selectMove(4));
    }

    @FXML
    private void goToLauncher() {
        AppStart.setScene("Launcher");
    }

    private void selectMove(int slot) {
        String line = "Good job, you managed to select Move " + slot + " successfully.";
        log += !log.equals("") ? "\n" + line : line;
        txt_log.setText(log);
    }

    public static void setTeam(int which, Creature[] team) {
        if (which == 1)
            party1 = team;
        else if (which == 2)
            party2 = team;
    }
}
