/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.mysql.services;

import com.root101.module.util.mysql.core.domain.Configuration;
import com.root101.module.util.mysql.core.module.MySQLCoreModule;
import com.root101.module.util.mysql.core.usecase_def.MySQLUseCase;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MySQLHandler {

    private static MySQLUseCase MySQLUC = MySQLCoreModule.init().getImplementation(MySQLUseCase.class);

    private MySQLHandler() {
    }

    public static void init() {
        System.out.println("Iniciando 'Base de Datos'");
        try {
            MySQLResourceService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MySQLHandler.start();
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

    public static void save(String DB_name, String... tables) {
        MySQLUC.save(DB_name, tables);
    }

    public static Configuration load() throws Exception {
        return MySQLUC.read();
    }

    public static boolean isRunning() {
        return MySQLUC.isRunning();
    }

    public static Map propertiesMap(String DB_Name) throws Exception {
        Configuration cfg = load();
        HashMap map = new HashMap();
        String url = "jdbc:mysql://" + cfg.getIp() + ":" + cfg.getPort() + "/" + DB_Name + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        map.put("javax.persistence.jdbc.url", url);
        map.put("javax.persistence.jdbc.user", cfg.getUser());
        map.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        map.put("javax.persistence.jdbc.password", cfg.getPass());
        return map;
    }

    public static void addPropertyChangeListener(PropertyChangeListener pl) {
        MySQLUC.addPropertyChangeListener(pl);
    }

    public static void removePropertyChangeListener(PropertyChangeListener pl) {
        MySQLUC.removePropertyChangeListener(pl);
    }
}
