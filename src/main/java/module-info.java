module com.sshconsole.sshconsole {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.github.kwhat.jnativehook;
    requires org.json;

    opens com.sshconsole.sshconsole to javafx.fxml;
    exports com.sshconsole.sshconsole;
    exports com.sshconsole.sshconsole.Controllers;
    opens com.sshconsole.sshconsole.Controllers to javafx.fxml;
}