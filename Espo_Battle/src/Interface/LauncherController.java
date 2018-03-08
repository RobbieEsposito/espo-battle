package Interface;
import javafx.fxml.FXML;

public class LauncherController {
    @FXML
    private void goToTeamBuilder() {
        AppStart.setScene("TeamBuilder");
    }

    @FXML
    private void goToBattle() {
        AppStart.setScene("Battle");
    }
}