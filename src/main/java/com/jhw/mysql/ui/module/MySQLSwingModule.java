package com.jhw.mysql.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.mysql.core.module.MySQLCoreModule;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.mysql.repo.module.MySQLRepoModule;
import com.jhw.swing.util.AbstractActionUtils;
import javax.swing.ImageIcon;
import com.jhw.mysql.core.usecase_def.MySQLUseCase;

public class MySQLSwingModule implements AbstractSwingMainModule {

    private final MySQLModuleNavigator navigator = new MySQLModuleNavigator();

    public static MySQLUseCase MySQLUC;

    public MySQLSwingModule() {
        init();
    }

    private void init() {
        System.out.println("Creando 'MySQL'");

        MySQLCoreModule core = MySQLCoreModule.init(MySQLRepoModule.init());
        MySQLUC = core.getImplementation(MySQLUseCase.class);
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerLicence(app);
    }

    private void registerLicence(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

       
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
