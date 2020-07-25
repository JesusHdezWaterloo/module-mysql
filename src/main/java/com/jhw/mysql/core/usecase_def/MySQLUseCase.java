package com.jhw.mysql.core.usecase_def;

import com.clean.core.app.usecase.ReadWriteUseCase;
import com.jhw.mysql.core.domain.Configuration;
import java.util.List;

/**
 * Interfaz del caso de uso de la licencia para definir las principales
 * funcionalidades de la licencia
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MySQLUseCase extends ReadWriteUseCase<Configuration> {

    public void start();

    public void close();

    public void save();

    public void update(List<String> sqlToRun);
}