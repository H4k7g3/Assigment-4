package com.company.controllers;

import com.company.entities.Med;
import com.company.repositories.interfaces.IMedRepository;

import java.sql.Date;
import java.util.List;

public class MedController {
    private final IMedRepository repo;

    public MedController(IMedRepository repo) {
        this.repo = repo;
    }

    public String createMed(String name, int price, Date expiration, String manufacturer, boolean byrecept) {
       /* boolean YES = (byrecept.toString().equals("YES"));
        boolean NO = (byrecept.toString().equals("NO"));*/
        Med med = new Med(name,price,expiration,manufacturer,byrecept);

        boolean created = repo.createMed(med);

        return (created ? "Medicine was created!" : "Medicine creation was failed!");
    }

    public String getMed(int id) {
        Med med = repo.getMed(id);

        return (med == null ? "Medicine was not found!" : med.toString());
    }

    public String getMedByName(String name){
        Med med = repo.getMedByName(name);

        return (med==null ?"Medicine was not found":med.toString());
    }

    public String getAllMeds() {
        List<Med> meds = repo.getAllMeds();

        return meds.toString();
    }

    public void removeMedById(int id) {
        String answer;
        repo.removeMedById(id);
    }
}