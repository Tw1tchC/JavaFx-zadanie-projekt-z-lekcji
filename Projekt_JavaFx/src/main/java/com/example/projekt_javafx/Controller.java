package com.example.projekt_javafx;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField postalField;
    @FXML private PasswordField passwordField;

    @FXML private RadioButton maleRadio;
    @FXML private RadioButton femaleRadio;

    @FXML private CheckBox sportCheck;
    @FXML private CheckBox musicCheck;

    @FXML private Spinner<Integer> ageSpinner;
    @FXML private ChoiceBox<String> countryChoice;
    @FXML private Slider levelSlider;

    @FXML
    public void initialize() {
        ageSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 18));
        countryChoice.getItems().addAll("Polska", "Niemcy", "USA");
    }

    @FXML
    private void handleSubmit() {
        String name = nameField.getText();
        String email = emailField.getText();
        String postal = postalField.getText();

        if (name.isEmpty() || email.isEmpty() || postal.isEmpty()) {
            showAlert("Błąd", "Wypełnij wszystkie pola!");
            return;
        }

        if (!name.matches("[A-Z][a-z]+")) {
            showAlert("Błąd", "Imię musi zaczynać się wielką literą!");
            return;
        }

        if (!email.contains("@")) {
            showAlert("Błąd", "Email musi zawierać @!");
            return;
        }

        if (!postal.matches("\\d{2}-\\d{3}")) {
            showAlert("Błąd", "Kod pocztowy: xx-xxx");
            return;
        }

        if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
            showAlert("Błąd", "Wybierz płeć!");
            return;
        }

        showAlert("Sukces", "Dane poprawne!");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}