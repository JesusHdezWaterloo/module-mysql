package com.jhw.module.util.mysql.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
