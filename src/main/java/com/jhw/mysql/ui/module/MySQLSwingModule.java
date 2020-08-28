package com.jhw.mysql.ui.module;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.jhw.mysql.services.MySQLHandler;
import com.jhw.mysql.services.MySQLNotificationService;
import com.jhw.mysql.services.MySQLResourceService;

public class MySQLSwingModule extends DefaultAbstractSwingMainModule {

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
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

    @Override
    public void closeModule() {
        MySQLHandler.close();
    }
}
