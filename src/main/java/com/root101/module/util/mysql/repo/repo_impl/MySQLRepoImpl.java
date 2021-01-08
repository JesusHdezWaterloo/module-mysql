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
package com.root101.module.util.mysql.repo.repo_impl;

import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.module.util.mysql.core.domain.Configuration;
import javax.inject.Inject;
import com.root101.module.util.mysql.core.repo_def.MySQLRepo;
import com.root101.repo.json.JACKSONRepoGeneral;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
