package com.jhw.module.util.mysql.core.usecase_impl;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.jhw.module.util.mysql.core.domain.Configuration;
import com.jhw.module.util.mysql.core.module.MySQLCoreModule;
import javax.inject.Inject;
import com.jhw.module.util.mysql.core.repo_def.MySQLRepo;
import com.jhw.module.util.mysql.core.usecase_def.MySQLUseCase;
import com.root101.utils.others.Network;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MySQLUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements MySQLUseCase {

    public static final int DELAY = 3 * 1000;

    public static final String PROPERTY_STARTED = "mysql_started";
    public static final String PROPERTY_CLOSED = "mysql_closed";
    public static final String PROPERTY_SAVED = "mysql_saved";

    public static final String NOTIFICATION_SALVA_DB = "notification.mysql.saved";
    public static final String MSG_SAVED = "msg.mysql.success.saved_db";
    public static final String MSG_NO_SAVED = "msg.mysql.error.no_save";
    public static final String MSG_STARTED = "msg.mysql.success.started";
    public static final String MSG_NO_STARTED = "msg.mysql.error.no_start";
    public static final String MSG_CLOSED = "msg.mysql.success.closed";
    public static final String MSG_NO_CLOSED = "msg.mysql.error.no_close";

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final MySQLRepo repo = MySQLCoreModule.getInstance().getImplementation(MySQLRepo.class);

    private final DateTimeFormatter dtfDia = DateTimeFormatter.ISO_DATE;
    private final DateTimeFormatter dtfAll = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public MySQLUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public void save(String DB_name, String... tables) {
        try {
            if (!isRunning()) {
                throw new Exception("El servicio de MySQL no esta corriendo");
            }

            Configuration cfg = read();
            File folder = new File(new File("").getAbsolutePath() + File.separator + cfg.getDbSaveFolder() + File.separator + dtfDia.format(LocalDate.now()));
            folder.mkdirs();

            String exportCmd = cfg.getBatDumpFolder().replace(" ", "\" \"");

            exportCmd += " -u " + cfg.getUser();
            if (!cfg.getPass().isEmpty()) {
                exportCmd += " -p " + cfg.getPass();
            }
            exportCmd += " --port " + cfg.getPort() + " -d " + DB_name + " ";
            for (String t : tables) {
                exportCmd += t + " ";
            }
            exportCmd += "--no-data=FALSE --extended-insert=FALSE > ";
            exportCmd += (folder.getAbsolutePath() + File.separator + File.separator + DB_name + "_" + dtfAll.format(LocalDateTime.now()) + ".sql").replace(" ", "\" \"");

            int resp = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", exportCmd}).waitFor();
            if (resp == 0) {
                NotificationHandler.showNotification(NOTIFICATION_SALVA_DB,
                        ResourceHandler.getString(MSG_SAVED));
                    firePropertyChange(PROPERTY_SAVED, false, true);
            }
        } catch (Exception e) {
            Exception ex = new Exception(ResourceHandler.getString(MSG_NO_SAVED));
            ex.setStackTrace(e.getStackTrace());
            ExceptionHandler.handleException(ex);
        }
    }

    @Override
    public void start() {
        try {
            Configuration cfg = read();
            if (!cfg.isStartMysqlService()) {
                System.out.println("El FLAG para iniciar el servicio de MySQL está desactivado");
            } else if (isRunning()) {
                System.out.println("El servicio de MySQL ya esta corriendo");
            } else {
                String cmd = "start /B " + cfg.getBatStart();
                int resp = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd}).waitFor();
                Thread.sleep(3 * 1000);//pa si x si acaso
                if (resp == 0) {
                    NotificationHandler.showNotification(NotificationsGeneralType.NOTIFICATION_SUCCESS,
                            ResourceHandler.getString(MSG_STARTED));
                    firePropertyChange(PROPERTY_STARTED, false, true);
                }
            }
        } catch (Exception e) {
            Exception ex = new Exception(ResourceHandler.getString(MSG_NO_STARTED));
            ex.setStackTrace(e.getStackTrace());
            ExceptionHandler.handleException(ex);
        }
    }

    @Override
    public void close() {
        try {
            Configuration cfg = read();
            if (!cfg.isStartMysqlService()) {
                System.out.println("El FLAG para iniciar el servicio de MySQL está desactivado");
            } else if (!isRunning()) {
                System.out.println("El servicio de MySQL NO esta corriendo");
            } else {
                String cmd = "start /B " + cfg.getBatStop();
                int resp = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd}).waitFor();
                Thread.sleep(3 * 1000);//pa si x si acaso
                if (resp == 0) {
                    NotificationHandler.showNotification(NotificationsGeneralType.NOTIFICATION_SUCCESS,
                            ResourceHandler.getString(MSG_CLOSED));
                    firePropertyChange(PROPERTY_CLOSED, false, true);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            Exception ex = new Exception(ResourceHandler.getString(MSG_NO_CLOSED));
            ex.setStackTrace(e.getStackTrace());
            ExceptionHandler.handleException(ex);
        }
    }

    @Override
    public void update(List<String> sqlToRun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRunning() {
        try {
            Configuration cfg = read();
            return Network.isRunning(cfg.getIp(), cfg.getPort());
        } catch (Exception e) {
            return false;
        }
    }

}
