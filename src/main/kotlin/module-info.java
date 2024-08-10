module com.qk.quark {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;

    opens com.qk.quark to javafx.fxml;
    exports com.qk.quark;
}
