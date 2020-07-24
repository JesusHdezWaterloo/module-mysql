/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.company;

import com.jhw.company.core.domain.Company;
import com.jhw.company.core.module.CompanyCoreModule;
import com.jhw.company.core.repo_def.CompanyRepo;
import com.jhw.company.core.usecase_def.CompanyUseCase;
import com.jhw.company.repo.module.CompanyRepoModule;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Company comp = new Company("comp.png", "module-comp");

        CompanyRepoModule repo = CompanyRepoModule.init();
        CompanyRepo companyUC = repo.getImplementation(CompanyRepo.class);
        companyUC.write(comp);
    }

}
