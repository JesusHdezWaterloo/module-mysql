package com.jhw.company.repo.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de licencia-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CompanyRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new InjectionConfigCompanyRepo());

    private static CompanyRepoModule INSTANCE;

    private CompanyRepoModule() {
    }

    public static CompanyRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Person no se ha inicializado");
        }
        return INSTANCE;
    }

    public static CompanyRepoModule init() {
        INSTANCE = new CompanyRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Licence Repo Module";
    }

}
