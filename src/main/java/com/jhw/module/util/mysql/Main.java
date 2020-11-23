/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.mysql;

import com.jhw.module.util.mysql.services.MySQLHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println(MySQLHandler.isRunning());
        MySQLHandler.start();
        MySQLHandler.save("admin_kanban");
        MySQLHandler.close();
        System.out.println(MySQLHandler.isRunning());
    }

}
