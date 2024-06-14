module com.kursinis.kursinis {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires mysql.connector.j;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;
    requires org.kordamp.bootstrapfx.core;

    opens com.kursinis.kursinis to javafx.fxml;
    exports com.kursinis.kursinis;
    opens com.kursinis.kursinis.fxControllers to javafx.fxml;
    exports com.kursinis.kursinis.fxControllers;
    opens com.kursinis.kursinis.model to javafx.base, org.hibernate.orm.core, jakarta.persistence, java.base;
    exports com.kursinis.kursinis.model to javafx.fxml, org.hibernate.orm.core, jakarta.persistence, java.base;
}