module com.qk.quark {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.qk.controller to javafx.fxml;
    exports com.qk.quark;
    exports com.qk.controller;
}
