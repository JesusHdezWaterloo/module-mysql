/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.mysql.services;

import com.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.jhw.utils.jpa.NonExistingEntityException;
import javax.persistence.RollbackException;
import org.eclipse.persistence.exceptions.DatabaseException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javax.persistence.PersistenceException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MySQLExceptionsTypes {

    public static final String EXCEPTION_PERSISTENCE_GENERAL = ExceptionHandlerServiceFunctional.getExceptionType(PersistenceException.class);

    //violacion de integridad, generalmente cuando se quiere crear un objeto que ya existe otro con igual unique
    public static final String EXCEPTION_JPA_INTEGRITY = ExceptionHandlerServiceFunctional.getExceptionType(RollbackException.class);
    public static final String MSG_JPA_INTEGRITY = "msg.default_config.error.jpa_integrity";

    //cuando se va a eliminar o editar un entity que ya no existe
    public static final String EXCEPTION_JPA_NON_EXISTING_ENTITY = ExceptionHandlerServiceFunctional.getExceptionType(NonExistingEntityException.class);
    public static final String MSG_JPA_NON_EXISTING_ENTITY = "msg.default_config.error.jpa_non_existing_entity";

    public static final String EXCEPTION_DATABASE = ExceptionHandlerServiceFunctional.getExceptionType(DatabaseException.class);
    
    public static final String EXCEPTION_COMMUNICATION = ExceptionHandlerServiceFunctional.getExceptionType(CommunicationsException.class);
    public static final String MSG_COMMUNICATION = "msg.mysql.error.communication";

}
