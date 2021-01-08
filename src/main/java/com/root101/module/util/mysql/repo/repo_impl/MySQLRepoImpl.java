package com.root101.module.util.mysql.repo.repo_impl;

import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.module.util.mysql.core.domain.Configuration;
import javax.inject.Inject;
import com.root101.module.util.mysql.core.repo_def.MySQLRepo;
import com.root101.repo.json.JACKSONRepoGeneral;

/**
 * Implementacion de la Interfaz {@code LicenceRepo} para manejar el
 * comportamiento de las definiciones de su interfaz
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MySQLRepoImpl extends JACKSONRepoGeneral<Configuration> implements MySQLRepo {

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public MySQLRepoImpl() {
        super("data_base_config.json", Configuration.class);
    }

    @Override
    protected void onReadError(Exception e) {
        NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_INFO,
                ResourceHandler.getString("msg.mysql.error.read"));
    }
}
