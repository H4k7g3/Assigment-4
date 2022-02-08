package com.company.repositories.interfaces;

import com.company.entities.Med;

import java.util.List;

public interface IMedRepository {
    boolean createMed(Med med);
    Med getMed(int id);
    Med getMedByName(String name);
    List<Med> getAllMeds();
    void removeMedById(int id);
}