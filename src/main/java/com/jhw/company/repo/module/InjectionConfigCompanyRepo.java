package com.jhw.company.repo.module;

import com.jhw.company.repo.repo_impl.CompanyRepoImpl;
import com.google.inject.AbstractModule;
import com.jhw.company.core.repo_def.CompanyRepo;

/**
 * Configuracion del injection del modulo de licencia-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class InjectionConfigCompanyRepo extends AbstractModule {

    @Override
    protected void configure() {
        bind(CompanyRepo.class).to(CompanyRepoImpl.class);
    }

}
