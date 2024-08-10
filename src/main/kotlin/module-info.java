module com.qk.quark {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;

    opens com.qk.views to javafx.fxml;
    exports com.qk.quark;
    exports com.qk.views;
}
