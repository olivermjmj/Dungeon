module com.nation.dungeon {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.net.http;

    opens com.nation.dungeon to javafx.fxml;
    exports com.nation.dungeon;
    exports com.nation.dungeon.util;
    opens com.nation.dungeon.util to javafx.fxml;
    exports com.nation.dungeon.controllers;
    opens com.nation.dungeon.controllers to javafx.fxml;
}