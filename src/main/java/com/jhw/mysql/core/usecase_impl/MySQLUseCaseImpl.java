package com.jhw.mysql.core.usecase_impl;

import com.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.jhw.mysql.core.domain.Configuration;
import com.jhw.mysql.core.module.MySQLCoreModule;
import javax.inject.Inject;
import com.jhw.mysql.core.repo_def.MySQLRepo;
import com.jhw.mysql.core.usecase_def.MySQLUseCase;
import java.util.List;

public class MySQLUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements MySQLUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final MySQLRepo repo = MySQLCoreModule.getInstance().getImplementation(MySQLRepo.class);

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public MySQLUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(List<String> sqlToRun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
