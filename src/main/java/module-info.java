module com.example.demoimage {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens com.example.demoimage to javafx.fxml;
  exports com.example.demoimage;
}