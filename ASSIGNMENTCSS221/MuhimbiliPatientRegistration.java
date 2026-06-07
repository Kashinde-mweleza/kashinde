package muhimbilipatientregistration;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.*;

public class MuhimbiliPatientRegistration extends Application {

    @Override
    public void start(Stage stage) {
        
        // ===== MAIN CONTAINER WITH BACKGROUND =====
        BorderPane mainContainer = new BorderPane();
        
        // Create a gradient background
        BackgroundFill gradientFill = new BackgroundFill(
            new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#e3f2fd")),  // Light blue
                new Stop(1, Color.web("#bbdefb"))   // Slightly darker blue
            ),
            CornerRadii.EMPTY,
            Insets.EMPTY
        );
        mainContainer.setBackground(new Background(gradientFill));

        // ===== HEADER WITH HOSPITAL NAME =====
        HBox headerContent = new HBox(20);
        headerContent.setAlignment(Pos.CENTER_LEFT);
        headerContent.setPadding(new Insets(15, 20, 15, 20));
        
        // Hospital icon (keeping only this emoji)
        Label logoIcon = new Label("🏥");
        logoIcon.setStyle("-fx-font-size: 48px;");
        
        VBox titleBox = new VBox(5);
        Label title = new Label("ZAHANATI YA MAHINA MWANZA");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0d47a1;"); // Dark blue
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label subtitle = new Label("Hospital Registration System · Mfumo wa Usajili wa Wagonjwa");
        subtitle.setStyle("-fx-font-size: 14px; -fx-text-fill: #1565c0;"); // Medium blue
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
        titleBox.getChildren().addAll(title, subtitle);
        
        // Right side date/time
        VBox dateBox = new VBox(5);
        dateBox.setAlignment(Pos.CENTER_RIGHT);
        Label dateLabel = new Label("Registration Date\nTarehe ya Usajili");
        dateLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-text-alignment: center;");
        dateLabel.setTextAlignment(TextAlignment.CENTER);
        
        TextField dateField = new TextField("12/03/2026 10:45 AM");
        dateField.setEditable(false);
        dateField.setStyle("-fx-background-color: white; -fx-border-color: #90caf9; -fx-border-width: 2; -fx-border-radius: 5; -fx-font-size: 14px; -fx-font-weight: bold;");
        dateField.setMaxWidth(200);
        dateField.setAlignment(Pos.CENTER);
        
        dateBox.getChildren().addAll(dateLabel, dateField);
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        headerContent.getChildren().addAll(logoIcon, titleBox, spacer, dateBox);
        
        // Separator line
        Separator headerSeparator = new Separator();
        headerSeparator.setStyle("-fx-background-color: #1976d2; -fx-height: 3;");
        
        VBox header = new VBox(headerContent, headerSeparator);

        // ===== LEFT SIDE: PATIENT BIODATA =====
        VBox leftCard = new VBox(15);
        leftCard.setStyle("-fx-background-color: white; -fx-padding: 20; -fx-background-radius: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);");
        leftCard.setPrefWidth(350);
        
        Label bioTitle = new Label("PATIENT BIODATA\nTAARIFA ZA MGONJWA");
        bioTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-border-color: transparent transparent #1976d2 transparent; -fx-border-width: 0 0 3 0; -fx-padding: 0 0 10 0; -fx-text-alignment: center;");
        bioTitle.setTextAlignment(TextAlignment.CENTER);
        bioTitle.setAlignment(Pos.CENTER);
        
        GridPane leftGrid = new GridPane();
        leftGrid.setHgap(15);
        leftGrid.setVgap(15);
        leftGrid.setPadding(new Insets(10, 0, 0, 0));
        
        // Row 0: Patient File Number
        Label fileNoLabel = new Label("File Number\nNamba ya Faili:");
        fileNoLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px; -fx-text-alignment: left;");
        TextField fileNoField = new TextField("MNH-2026-00125");
        fileNoField.setStyle("-fx-background-color: #e3f2fd; -fx-border-color: #1976d2; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        fileNoField.setEditable(false);
        
        // Row 1: First Name
        Label firstNameLabel = new Label("First Name\nJina la Kwanza:");
        firstNameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter first name");
        firstNameField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Row 2: Last Name
        Label lastNameLabel = new Label("Last Name\nJina la Mwisho:");
        lastNameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter last name");
        lastNameField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Row 3: Gender
        Label genderLabel = new Label("Gender\nJinsia:");
        genderLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        ComboBox<String> genderBox = new ComboBox<>();
        genderBox.getItems().addAll("Male", "Female");
        genderBox.setPromptText("Select gender");
        genderBox.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px;");
        genderBox.setPrefHeight(35);
        
        // Row 4: Date of Birth
        Label dobLabel = new Label("Date of Birth\nTarehe ya Kuzaliwa:");
        dobLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        HBox dobBox = new HBox(8);
        
        ComboBox<String> dayBox = new ComboBox<>();
        dayBox.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                               "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
        dayBox.setPromptText("Day");
        dayBox.setPrefWidth(70);
        dayBox.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5;");
        
        ComboBox<String> monthBox = new ComboBox<>();
        monthBox.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                 "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthBox.setPromptText("Month");
        monthBox.setPrefWidth(80);
        monthBox.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5;");
        
        ComboBox<String> yearBox = new ComboBox<>();
        yearBox.getItems().addAll("1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960",
                                "1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971",
                                "1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982",
                                "1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993",
                                "1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004",
                                "2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
                                "2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026");
        yearBox.setPromptText("Year");
        yearBox.setPrefWidth(80);
        yearBox.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5;");
        
        dobBox.getChildren().addAll(dayBox, monthBox, yearBox);
        
        // Row 5: Marital Status
        Label maritalLabel = new Label("Marital Status\nHali ya Ndoa:");
        maritalLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        ComboBox<String> marital = new ComboBox<>();
        marital.getItems().addAll("Single", 
                                 "Married", 
                                 "Divorced", 
                                 "Widowed");
        marital.setPromptText("Select status");
        marital.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px;");
        marital.setPrefHeight(35);
        
        // Add all to grid
        leftGrid.add(fileNoLabel, 0, 0);
        leftGrid.add(fileNoField, 1, 0);
        leftGrid.add(firstNameLabel, 0, 1);
        leftGrid.add(firstNameField, 1, 1);
        leftGrid.add(lastNameLabel, 0, 2);
        leftGrid.add(lastNameField, 1, 2);
        leftGrid.add(genderLabel, 0, 3);
        leftGrid.add(genderBox, 1, 3);
        leftGrid.add(dobLabel, 0, 4);
        leftGrid.add(dobBox, 1, 4);
        leftGrid.add(maritalLabel, 0, 5);
        leftGrid.add(marital, 1, 5);
        
        // Set column widths
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(130);
        col1.setPrefWidth(130);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(180);
        col2.setPrefWidth(180);
        leftGrid.getColumnConstraints().addAll(col1, col2);
        
        leftCard.getChildren().addAll(bioTitle, leftGrid);

        // ===== RIGHT SIDE: CONTACT & MEDICAL INFO =====
        VBox rightCard = new VBox(15);
        rightCard.setStyle("-fx-background-color: white; -fx-padding: 20; -fx-background-radius: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);");
        rightCard.setPrefWidth(400);
        
        Label contactTitle = new Label("CONTACT & MEDICAL INFORMATION\nMAWASILIANO NA TAARIFA ZA KIAFYA");
        contactTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-border-color: transparent transparent #1976d2 transparent; -fx-border-width: 0 0 3 0; -fx-padding: 0 0 10 0; -fx-text-alignment: center;");
        contactTitle.setTextAlignment(TextAlignment.CENTER);
        contactTitle.setWrapText(true);
        
        GridPane rightGrid = new GridPane();
        rightGrid.setHgap(15);
        rightGrid.setVgap(15);
        rightGrid.setPadding(new Insets(10, 0, 0, 0));
        
        // Row 0: Phone Number
        Label phoneLabel = new Label("Phone Number\nNamba ya Simu:");
        phoneLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField phoneField = new TextField();
        phoneField.setPromptText("e.g., 0712 345 678");
        phoneField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Row 1: Region
        Label regionLabel = new Label("Region\nMkoa:");
        regionLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        ComboBox<String> region = new ComboBox<>();
        region.getItems().addAll(
                "Dar es Salaam", "Morogoro", "Dodoma", "Mwanza", "Arusha", 
                "Mbeya", "Tanga", "Kilimanjaro", "Zanzibar", "Kagera", "Kigoma");
        region.setPromptText("Select region");
        region.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px;");
        region.setPrefHeight(35);
        
        // Row 2: District
        Label districtLabel = new Label("District\nWilaya:");
        districtLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField districtField = new TextField();
        districtField.setPromptText("Enter district");
        districtField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Row 3: Clinic/Department
        Label clinicLabel = new Label("Clinic / Department\nKliniki / Idara:");
        clinicLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        ComboBox<String> clinic = new ComboBox<>();
        clinic.getItems().addAll(
                "Outpatient Department (OPD)",
                "Dental Clinic",
                "Eye Clinic",
                "Maternity",
                "Surgical Clinic",
                "Pediatric Clinic",
                "Cardiology Clinic",
                "Orthopedic Clinic");
        clinic.setPromptText("Select clinic");
        clinic.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px;");
        clinic.setPrefHeight(35);
        
        // Row 4: Blood Group
        Label bloodGroupLabel = new Label("Blood Group\nKundi la Damu:");
        bloodGroupLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        ComboBox<String> bloodGroup = new ComboBox<>();
        bloodGroup.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", "Unknown");
        bloodGroup.setPromptText("Select blood group");
        bloodGroup.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px;");
        bloodGroup.setPrefHeight(35);
        
        // Row 5: Allergies
        Label allergiesLabel = new Label("Allergies\nMizio:");
        allergiesLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField allergiesField = new TextField();
        allergiesField.setPromptText("Any known allergies?");
        allergiesField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Row 6: Emergency Contact
        Label emergencyLabel = new Label("Emergency Contact\nAnwani ya Dharura:");
        emergencyLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        TextField emergencyField = new TextField();
        emergencyField.setPromptText("Name and phone");
        emergencyField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        rightGrid.add(phoneLabel, 0, 0);
        rightGrid.add(phoneField, 1, 0);
        rightGrid.add(regionLabel, 0, 1);
        rightGrid.add(region, 1, 1);
        rightGrid.add(districtLabel, 0, 2);
        rightGrid.add(districtField, 1, 2);
        rightGrid.add(clinicLabel, 0, 3);
        rightGrid.add(clinic, 1, 3);
        rightGrid.add(bloodGroupLabel, 0, 4);
        rightGrid.add(bloodGroup, 1, 4);
        rightGrid.add(allergiesLabel, 0, 5);
        rightGrid.add(allergiesField, 1, 5);
        rightGrid.add(emergencyLabel, 0, 6);
        rightGrid.add(emergencyField, 1, 6);
        
        // Set column constraints
        ColumnConstraints rightCol1 = new ColumnConstraints();
        rightCol1.setMinWidth(150);
        rightCol1.setPrefWidth(150);
        ColumnConstraints rightCol2 = new ColumnConstraints();
        rightCol2.setMinWidth(200);
        rightCol2.setPrefWidth(200);
        rightGrid.getColumnConstraints().addAll(rightCol1, rightCol2);
        
        rightCard.getChildren().addAll(contactTitle, rightGrid);

        // ===== PAYMENT METHOD SECTION =====
        VBox paymentCard = new VBox(15);
        paymentCard.setStyle("-fx-background-color: white; -fx-padding: 20; -fx-background-radius: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);");
        paymentCard.setPrefWidth(280);
        
        Label paymentTitle = new Label("PAYMENT METHOD\nNJIA YA MALIPO");
        paymentTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-border-color: transparent transparent #1976d2 transparent; -fx-border-width: 0 0 3 0; -fx-padding: 0 0 10 0; -fx-text-alignment: center;");
        paymentTitle.setTextAlignment(TextAlignment.CENTER);
        
        ToggleGroup paymentGroup = new ToggleGroup();

        RadioButton nhif = new RadioButton("NHIF");
        nhif.setToggleGroup(paymentGroup);
        nhif.setSelected(true);
        nhif.setStyle("-fx-text-fill: #0d47a1; -fx-font-weight: bold; -fx-font-size: 13px;");

        RadioButton cash = new RadioButton("Cash");
        cash.setToggleGroup(paymentGroup);
        cash.setStyle("-fx-text-fill: #0d47a1; -fx-font-size: 13px;");

        RadioButton exempted = new RadioButton("Exempted");
        exempted.setToggleGroup(paymentGroup);
        exempted.setStyle("-fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        
        // NHIF Number field
        Label nhifNumberLabel = new Label("NHIF Number\nNamba ya NHIF:");
        nhifNumberLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        nhifNumberLabel.setPadding(new Insets(10, 0, 0, 0));
        
        TextField nhifNumberField = new TextField();
        nhifNumberField.setPromptText("Enter NHIF number");
        nhifNumberField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        // Other Insurance
        Label insuranceLabel = new Label("Other Insurance\nBima Nyingine:");
        insuranceLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d47a1; -fx-font-size: 13px;");
        insuranceLabel.setPadding(new Insets(10, 0, 0, 0));
        
        TextField insuranceField = new TextField();
        insuranceField.setPromptText("Insurance details");
        insuranceField.setStyle("-fx-border-color: #90caf9; -fx-border-radius: 5; -fx-font-size: 13px; -fx-padding: 8;");
        
        VBox paymentBox = new VBox(10, nhif, cash, exempted, 
                                  nhifNumberLabel, nhifNumberField,
                                  insuranceLabel, insuranceField);
        paymentBox.setPadding(new Insets(5, 0, 0, 15));
        
        paymentCard.getChildren().addAll(paymentTitle, paymentBox);

        // ===== MAIN BODY =====
        HBox body = new HBox(20, leftCard, rightCard, paymentCard);
        body.setPadding(new Insets(20));
        body.setAlignment(Pos.CENTER);

        // ===== BUTTONS =====
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20, 0, 20, 0));
        
        Button saveBtn = new Button("SAVE PATIENT\nHIFADHI MGONJWA");
        saveBtn.setStyle("-fx-background-color: #0d47a1; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12 25; -fx-background-radius: 8; -fx-font-size: 14px; -fx-cursor: hand; -fx-text-alignment: center;");
        saveBtn.setTextAlignment(TextAlignment.CENTER);
        
        Button clearBtn = new Button("CLEAR FORM\nFUTA FOMU");
        clearBtn.setStyle("-fx-background-color: #ff8f00; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12 25; -fx-background-radius: 8; -fx-font-size: 14px; -fx-cursor: hand; -fx-text-alignment: center;");
        clearBtn.setTextAlignment(TextAlignment.CENTER);
        
        Button exitBtn = new Button("EXIT\nTOKA");
        exitBtn.setStyle("-fx-background-color: #c62828; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 12 25; -fx-background-radius: 8; -fx-font-size: 14px; -fx-cursor: hand; -fx-text-alignment: center;");
        exitBtn.setTextAlignment(TextAlignment.CENTER);

        buttons.getChildren().addAll(saveBtn, clearBtn, exitBtn);

        // ===== STATUS BAR =====
        HBox statusBar = new HBox();
        statusBar.setStyle("-fx-background-color: #0d47a1; -fx-padding: 8 20;");
        Label statusLabel = new Label("System ready · Mfumo uko tayari | User: Admin | Date: 12/03/2026 | ZAHANATI YA MAHINA MWANZA");
        statusLabel.setStyle("-fx-text-fill: white; -fx-font-size: 12px; -fx-font-weight: bold;");
        statusBar.getChildren().add(statusLabel);

        // ===== ROOT LAYOUT =====
        VBox root = new VBox(header, body, buttons, statusBar);
        root.setPadding(new Insets(0));
        
        // Set up actions
        exitBtn.setOnAction(e -> stage.close());
        
        clearBtn.setOnAction(e -> {
            firstNameField.clear();
            lastNameField.clear();
            phoneField.clear();
            districtField.clear();
            allergiesField.clear();
            emergencyField.clear();
            nhifNumberField.clear();
            insuranceField.clear();
            genderBox.setValue(null);
            marital.setValue(null);
            region.setValue(null);
            clinic.setValue(null);
            bloodGroup.setValue(null);
            dayBox.setValue(null);
            monthBox.setValue(null);
            yearBox.setValue(null);
            nhif.setSelected(true);
        });

        // ===== SCENE SETUP =====
        Scene scene = new Scene(root, 1300, 750);
        stage.setScene(scene);
        stage.setTitle("ZAHANATI YA MAHINA MWANZA - Hospital Patient Registration System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}