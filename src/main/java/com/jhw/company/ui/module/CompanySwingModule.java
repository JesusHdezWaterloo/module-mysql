package com.jhw.company.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.company.core.module.CompanyCoreModule;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.company.core.usecase_def.CompanyUseCase;
import com.jhw.company.repo.module.CompanyRepoModule;
import com.jhw.swing.util.AbstractActionUtils;
import javax.swing.ImageIcon;

public class CompanySwingModule implements AbstractSwingMainModule {

    private final CompanyModuleNavigator navigator = new CompanyModuleNavigator();

    public static CompanyUseCase companyUC;

    public CompanySwingModule() {
        init();
    }

    private void init() {
        System.out.println("Creando 'Company'");

        CompanyCoreModule core = CompanyCoreModule.init(CompanyRepoModule.init());
        companyUC = core.getImplementation(CompanyUseCase.class);
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerLicence(app);
    }

    private void registerLicence(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        ImageIcon icon = MaterialIcons.BROKEN_IMAGE;
        try {
            icon = new ImageIcon(companyUC.getImageURL());
        } catch (Exception e) {
        }
        String name = "Nombre de la Compañía";
        try {
            name = companyUC.getName();
        } catch (Exception e) {
        }
        dash.putKeyValue(DashboardConstants.UP_COMPANY,
                AbstractActionUtils.from(name, icon));

    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
