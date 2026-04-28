package sample;

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

    @FXML private ChoiceBox<String> countryChoice;
    @FXML private Spinner<Integer> ageSpinner;
    @FXML private Slider ratingSlider;

    @FXML private Label resultName;
    @FXML private Label resultEmail;
    @FXML private Label resultPostal;
    @FXML private Label resultGender;
    @FXML private Label resultHobbies;
    @FXML private Label resultCountry;
    @FXML private Label resultAge;
    @FXML private Label resultRating;

    @FXML
    public void initialize() {
        countryChoice.getItems().addAll("Polska", "Niemcy", "USA");

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 18);
        ageSpinner.setValueFactory(valueFactory);
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

        if (!name.matches("[A-Z].*")) {
            showAlert("Błąd", "Imię musi zaczynać się wielką literą!");
            return;
        }

        if (!email.contains("@")) {
            showAlert("Błąd", "Email musi zawierać @!");
            return;
        }

        if (!postal.matches("\\d{2}-\\d{3}")) {
            showAlert("Błąd", "Kod pocztowy musi być w formacie XX-XXX!");
            return;
        }

        if (!sportCheck.isSelected() && !musicCheck.isSelected()) {
            showAlert("Błąd", "Wybierz przynajmniej jedno zainteresowanie!");
            return;
        }

        if (countryChoice.getValue() == null) {
            showAlert("Błąd", "Wybierz kraj!");
            return;
        }

        String gender = maleRadio.isSelected() ? "Mężczyzna" :
                femaleRadio.isSelected() ? "Kobieta" : "Brak";

        String hobbies = "";
        if (sportCheck.isSelected()) hobbies += "Sport ";
        if (musicCheck.isSelected()) hobbies += "Muzyka ";

        resultName.setText("Imię: " + name);
        resultEmail.setText("Email: " + email);
        resultPostal.setText("Kod: " + postal);
        resultGender.setText("Płeć: " + gender);
        resultHobbies.setText("Zainteresowania: " + hobbies);
        resultCountry.setText("Kraj: " + countryChoice.getValue());
        resultAge.setText("Wiek: " + ageSpinner.getValue());
        resultRating.setText("Ocena: " + (int) ratingSlider.getValue());


        resultName.getStyleClass().add("success");
        resultEmail.getStyleClass().add("success");
        resultPostal.getStyleClass().add("success");
        resultGender.getStyleClass().add("success");
        resultHobbies.getStyleClass().add("success");
        resultCountry.getStyleClass().add("success");
        resultAge.getStyleClass().add("success");
        resultRating.getStyleClass().add("success");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}