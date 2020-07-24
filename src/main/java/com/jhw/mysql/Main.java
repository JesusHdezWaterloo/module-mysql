/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.mysql;

import com.jhw.mysql.core.module.MySQLCoreModule;
import com.jhw.mysql.core.usecase_def.MySQLUseCase;
import com.jhw.mysql.repo.module.MySQLRepoModule;
import static com.jhw.mysql.ui.module.MySQLSwingModule.MySQLUC;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MySQLCoreModule core = MySQLCoreModule.init(MySQLRepoModule.init());
        MySQLUseCase MySQLUC = core.getImplementation(MySQLUseCase.class);

        MySQLUC.read();
    }

}
