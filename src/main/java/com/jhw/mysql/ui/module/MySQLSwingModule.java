package com.jhw.mysql.ui.module;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.RootView;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.jhw.mysql.services.MySQLHandler;
import com.jhw.mysql.services.MySQLNotificationService;
import com.jhw.mysql.services.MySQLResourceService;
import java.beans.PropertyChangeEvent;

public class MySQLSwingModule implements AbstractSwingMainModule {

    private final MySQLModuleNavigator navigator = new MySQLModuleNavigator();

    private MySQLSwingModule() {
    }

    public static MySQLSwingModule init() {
        System.out.println("Iniciando 'Base de Datos'");
        MySQLNotificationService.init();

        try {
            MySQLResourceService.init();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return new MySQLSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        MySQLHandler.start();
        registerLicence(app);
    }

    private void registerLicence(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        app.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            switch (evt.getPropertyName()) {
                case RootView.ON_WINDOWS_CLOSING:
                    MySQLHandler.save();
                    MySQLHandler.close();
                    break;

            }
        });

    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
