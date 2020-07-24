package com.jhw.company.core.usecase_impl;

import com.jhw.company.core.module.CompanyCoreModule;
import com.jhw.company.core.repo_def.CompanyRepo;
import com.jhw.company.core.usecase_def.CompanyUseCase;
import javax.inject.Inject;

/**
 * Implementacion de la Interfaz {@code LicenceUseCase} para manejar el
 * comportamiento de las definiciones de su interfaz
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CompanyUseCaseImpl implements CompanyUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final CompanyRepo repo = CompanyCoreModule.getInstance().getImplementation(CompanyRepo.class);

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public CompanyUseCaseImpl() {
    }

    @Override
    public String getImageURL() throws Exception {
        return repo.read().getImage_URL();
    }

    @Override
    public String getName() throws Exception {
        return repo.read().getName();
    }

}
