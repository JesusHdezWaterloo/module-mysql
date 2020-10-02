package com.jhw.module.util.mysql.services;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationServiceFunctional;
import static com.jhw.module.util.mysql.core.usecase_impl.MySQLUseCaseImpl.NOTIFICATION_SALVA_DB;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.notification.NotificationBuilder;
import com.jhw.swing.notification.NotificationFactory;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MySQLNotificationService extends NotificationServiceFunctional {

    public static MySQLNotificationService init() {
        MySQLNotificationService notif = new MySQLNotificationService();
        Notification.registerNotificationService(notif);
        return notif;
    }

    private MySQLNotificationService() {
        addAll();
    }

    @Override
    protected void addNotifications() {
        super.addNotification(NOTIFICATION_SALVA_DB, (Object t) -> {
             NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds( 2 * PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text(t.toString())
                    .icon(MaterialIcons.SAVE)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_DONE)));
        });
    }

    @Override
    protected void addConfirmDialog() {
    }

    @Override
    protected void addInputDialog() {
    }
}
