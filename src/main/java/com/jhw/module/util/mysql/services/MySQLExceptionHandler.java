/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.mysql.services;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.domain.services.Resource;
import com.jhw.utils.exceptions.ExceptionHandlerUtil;
import com.jhw.utils.jpa.NonExistingEntityException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.io.File;
import java.net.MalformedURLException;
import java.util.function.Consumer;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MySQLExceptionHandler extends ExceptionHandlerServiceFunctional {

    public static MySQLExceptionHandler init() {
        MySQLExceptionHandler excep = new MySQLExceptionHandler();
        ExceptionHandler.registerExceptionHandlerService(excep);
        return excep;
    }

    public MySQLExceptionHandler() {
        addAll();
    }

    @Override
    protected void addAll() {
        addHandler(MySQLExceptionsTypes.EXCEPTION_JPA_INTEGRITY, (Throwable e) -> {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    Resource.getString(MySQLExceptionsTypes.MSG_JPA_INTEGRITY));
        });
        addHandler(MySQLExceptionsTypes.EXCEPTION_JPA_NON_EXISTING_ENTITY, (Throwable e) -> {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    Resource.getString(MySQLExceptionsTypes.MSG_JPA_NON_EXISTING_ENTITY));
        });
        addHandler(MySQLExceptionsTypes.EXCEPTION_PERSISTENCE_GENERAL, (Throwable e) -> {
            if (!(e.getCause() instanceof PersistenceException)) {
                ExceptionHandler.handleException(e.getCause());
            }
        });
        addHandler(MySQLExceptionsTypes.EXCEPTION_DATABASE, (Throwable e) -> {
            if (!(e.getCause() instanceof DatabaseException)) {
                ExceptionHandler.handleException(e.getCause());
            }
        });
        addHandler(MySQLExceptionsTypes.EXCEPTION_COMMUNICATION, (Throwable e) -> {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    Resource.getString(MySQLExceptionsTypes.MSG_COMMUNICATION));
        });
    }

}
