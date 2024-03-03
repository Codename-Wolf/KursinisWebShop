module coursework.kursiniswebshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    requires org.kordamp.bootstrapfx.core;

    opens coursework.kursiniswebshop to javafx.fxml;
    exports coursework.kursiniswebshop;
}