package com.jhw.company.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;

/**
 * Objeto dominio Company.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Company extends EntityDomainObjectValidated {

    @NotEmpty(message = "#msg.company.domain.no_image#")
    private String image_URL = "logo.png";

    @NotEmpty(message = "#msg.company.domain.no_name#")
    private String name = "company name";

    public Company() {
    }

    public Company(String image_URL, String name) {
        this.image_URL = image_URL;
        this.name = name;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
