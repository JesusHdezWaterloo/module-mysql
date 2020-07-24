package com.jhw.company.core.repo_def;

import com.clean.core.app.repo.ReadWriteRepository;
import com.jhw.company.core.domain.Company;

/**
 * Interfaz de Repo para definir el trabajo de almacenamiento de la compania.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface CompanyRepo extends ReadWriteRepository<Company> {

    /**
     * Lee la compania del fichero.
     *
     * @return la compania leida
     * @throws Exception si hay algun problema leyendo la compania
     */
    @Override
    public Company read() throws Exception;

    /**
     * Guarda la compania en el fichero
     *
     * @param comp Compania a guardar
     * @throws Exception si hay algun problema guardando la compania
     */
    @Override
    public void write(Company comp) throws Exception;
}
