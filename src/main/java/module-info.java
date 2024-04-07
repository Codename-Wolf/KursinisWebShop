module coursework.kursiniswebshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.j;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;
    requires org.kordamp.bootstrapfx.core;

    opens coursework.kursiniswebshop to javafx.fxml;
    exports coursework.kursiniswebshop;
    exports coursework.kursiniswebshop.fxControllers;
    opens coursework.kursiniswebshop.fxControllers to javafx.fxml;
}