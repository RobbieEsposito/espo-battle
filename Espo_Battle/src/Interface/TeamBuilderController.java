package Interface;

import Mechanics.Creature;

import Mechanics.TrainingBuild;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamBuilderController {
    private int partySlot = 0;
    private Creature[] party = new Creature[5];
    private Creature temp = new Creature();

    @FXML
    private ComboBox<String> cb_species;
    @FXML
    private ChoiceBox<String> cb_build;
    @FXML
    private ComboBox<String> cb_move1;
    @FXML
    private Button btn_edit1, btn_edit2, btn_edit3, btn_edit4, btn_edit5;
    @FXML
    private Label lbl_creature1, lbl_creature2, lbl_creature3, lbl_creature4, lbl_creature5;

    private static ArrayList<String> getCreaturesList() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Koalava", "Elastail", "Hejbog", "Gekknife", "Vineper", "Crystalis", "Elecho"));
        return list;
    }

    @FXML
    public void initialize() {
        for (int i = 0; i < 5; i++) {
            party[i] = new Creature();
        }
        ArrayList<String> creatures = getCreaturesList();
        ObservableList<String> speciesList = FXCollections.observableArrayList(creatures);
        cb_species.setItems(speciesList);
        cb_species.valueProperty().addListener((ov, t, t1) -> setSpecies(t1));

        ObservableList<String> buildList = FXCollections.observableArrayList(
                "Breaker", "Wall", "Speedster", "Tank", "Sweeper", "Survivalist");
        cb_build.setItems(buildList);
        cb_build.valueProperty().addListener((ov, t, t1) -> setBuild(t1));

        ObservableList<String> moveList = FXCollections.observableArrayList();
        cb_move1.setItems(moveList);
        cb_move1.valueProperty().addListener((ov, t, t1) -> setMove(t1, 0));

        btn_edit1.setOnAction(e -> changePartySlot(0));
        btn_edit2.setOnAction(e -> changePartySlot(1));
        btn_edit3.setOnAction(e -> changePartySlot(2));
        btn_edit4.setOnAction(e -> changePartySlot(3));
        btn_edit5.setOnAction(e -> changePartySlot(4));
        btn_edit1.setDisable(true);
    }

    private void changePartySlot(int slot) {
        partySlot = slot;
        ObservableList<String> moveList = FXCollections.observableArrayList(new ArrayList<String>());
        cb_move1.setItems(moveList);
        btn_edit1.setDisable(false);
        btn_edit2.setDisable(false);
        btn_edit3.setDisable(false);
        btn_edit4.setDisable(false);
        btn_edit5.setDisable(false);
        if (partySlot == 0)
            btn_edit1.setDisable(true);
        else if (partySlot == 1)
            btn_edit2.setDisable(true);
        else if (partySlot == 2)
            btn_edit3.setDisable(true);
        else if (partySlot == 3)
            btn_edit4.setDisable(true);
        else if (partySlot == 4)
            btn_edit5.setDisable(true);
        loadData();
    }

    private void setSpecies(String s) {
        temp = new Creature(s);
        if (!temp.getIsValid())
            return;
        ArrayList<String> movepool = temp.getMovepool();
        ObservableList<String> moveList =
                FXCollections.observableArrayList(movepool);
        cb_move1.setItems(moveList);
    }

    private void setBuild(String s) {
        if (!temp.getIsValid())
            return;
        if (s.equals(""))
            return;
        temp.setBuild(TrainingBuild.stringToBuild(s));
    }

    private void setMove(String s, int n) {
        if (!temp.getIsValid())
            return;
        if (s == null)
            return;
        Mechanics.Move m = new Mechanics.Move(s);
        temp.setMove(m, n);
    }

    @FXML
    private void saveCreature() {
        party[partySlot] = temp;
        BattleController.setTeam(1, party);
        if (party[0].getIsValid())
            lbl_creature1.setText(party[0].getName());
        if (party[1].getIsValid())
            lbl_creature2.setText(party[1].getName());
        if (party[2].getIsValid())
            lbl_creature3.setText(party[2].getName());
        if (party[3].getIsValid())
            lbl_creature4.setText(party[3].getName());
        if (party[4].getIsValid())
            lbl_creature5.setText(party[4].getName());
    }

    private void loadData() {
        temp = party[partySlot];

        // load species data
        if (!party[partySlot].getName().equals("Undefined"))
            cb_species.setValue(party[partySlot].getName());
        else
            cb_species.setValue("");

        // load build data
        if (party[partySlot].getBuild() == TrainingBuild.Build.NULL)
            cb_build.setValue(null);
        else
            cb_build.setValue(TrainingBuild.buildToString(party[partySlot].getBuild()));

        // load move data
        if (party[partySlot].getMove(0) != null)
            cb_move1.setValue(party[partySlot].getMove(0).getName());
        else
            cb_move1.setValue("");
    }

    @FXML
    private void goToLauncher() {
        AppStart.setScene("Launcher");
    }
}