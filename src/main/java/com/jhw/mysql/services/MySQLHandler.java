/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.mysql.services;

import com.jhw.mysql.core.domain.Configuration;
import com.jhw.mysql.core.module.MySQLCoreModule;
import com.jhw.mysql.core.usecase_def.MySQLUseCase;
import com.jhw.mysql.repo.module.MySQLRepoModule;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MySQLHandler {

    private static MySQLUseCase MySQLUC = MySQLCoreModule.init(MySQLRepoModule.init()).getImplementation(MySQLUseCase.class);

    private MySQLHandler() {
    }

    public static void registerMySQLService(MySQLUseCase newService) {
        MySQLUC = newService;
    }

    public static void start() {
        MySQLUC.start();
    }

    public static void close() {
        MySQLUC.close();
    }

    public static void save() {
        MySQLUC.save();
    }

    public static Configuration load() throws Exception {
        return MySQLUC.read();
    }
}
