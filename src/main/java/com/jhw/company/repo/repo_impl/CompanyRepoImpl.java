package com.jhw.company.repo.repo_impl;

import com.jhw.company.core.domain.Company;
import com.jhw.utils.jackson.JACKSON;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.inject.Inject;
import com.jhw.company.core.repo_def.CompanyRepo;

/**
 * Implementacion de la Interfaz {@code LicenceRepo} para manejar el
 * comportamiento de las definiciones de su interfaz
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CompanyRepoImpl implements CompanyRepo {

    /**
     * Fichero donde se va a almacenar la licencia.
     */
    private File file = new File("company.json");

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public CompanyRepoImpl() {
    }

    /**
     * Lee la company del fichero.<\br>
     *
     * @return la company leida
     * @throws Exception si hay algun problema leyendo la company
     */
    @Override
    public Company read() throws Exception {
        try {
            return JACKSON.read(file, Company.class);
        } catch (Exception e) {
            write(new Company());
        }
        return new Company();
    }

    /**
     * Guarda la company en el fichero.<\br>
     *
     * @param comp Company a guardar
     * @throws Exception si hay algun problema guardando la company
     */
    @Override
    public void write(Company comp) throws Exception {
        JACKSON.write(file, comp);
    }

    /**
     * Getter del File donde se va a almacenar la licencia.
     *
     * @return File donde se va a almacenar la licencia.
     */
    public File getFile() {
        return file;
    }

    /**
     * Setter del File donde se va a almacenar la licencia.
     *
     * @param file donde se va a almacenar la licencia.
     */
    public void setFile(File file) {
        this.file = file;
    }

}
