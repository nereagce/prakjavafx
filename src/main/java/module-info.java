
open module gradlejavafx {
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.fxml;
  requires javafx.swing;
  requires javafx.web;
    requires com.google.common;
    exports ehu.isad;
}
