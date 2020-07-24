package com.jhw.mysql.services;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationServiceFunctional;
import static com.jhw.mysql.core.usecase_impl.MySQLUseCaseImpl.NOTIFICATION_SALVA_DB;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
import com.jhw.swing.personalization.PersonalizationMaterial;

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
    }

    @Override
    protected void addConfirmDialog() {
        super.addNotification(NOTIFICATION_SALVA_DB, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    5,
                    t.toString(),
                    MaterialIcons.SAVE,
                    PersonalizationMaterial.getInstance().getColorDone()
            );
        });
    }

    @Override
    protected void addInputDialog() {
    }
}
