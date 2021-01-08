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
package com.root101.module.util.mysql.core.domain;

import com.root101.utils.clean.EntityDomainObjectValidated;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class Configuration extends EntityDomainObjectValidated {

    private boolean startMysqlService = false;
    private String batDumpFolder = "E:\\xampp\\mysql\\bin\\mysqldump";
    private String batStart = "E:\\xampp\\mysql_start.bat";
    private String batStop = "E:\\xampp\\mysql_stop.bat";

    private boolean saveDbAfterClose = true;
    private String dbSaveFolder = "salvas_bd";
    private String user = "root";
    private String pass = "";
    private int port = 7733;
    private String ip = "localhost";

    public Configuration() {
    }

    public boolean isStartMysqlService() {
        return startMysqlService;
    }

    public void setStartMysqlService(boolean startMysqlService) {
        this.startMysqlService = startMysqlService;
    }

    public String getBatDumpFolder() {
        return batDumpFolder;
    }

    public void setBatDumpFolder(String batDumpFolder) {
        this.batDumpFolder = batDumpFolder;
    }

    public String getBatStart() {
        return batStart;
    }

    public void setBatStart(String batStart) {
        this.batStart = batStart;
    }

    public String getBatStop() {
        return batStop;
    }

    public void setBatStop(String batStop) {
        this.batStop = batStop;
    }

    public boolean isSaveDbAfterClose() {
        return saveDbAfterClose;
    }

    public void setSaveDbAfterClose(boolean saveDbAfterClose) {
        this.saveDbAfterClose = saveDbAfterClose;
    }

    public String getDbSaveFolder() {
        return dbSaveFolder;
    }

    public void setDbSaveFolder(String dbSaveFolder) {
        this.dbSaveFolder = dbSaveFolder;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
