package com.xtensus.passosyf.factories;

import org.springframework.stereotype.Component;

import com.xtensus.passosyf.entities.Etat;

@Component
public class EtatFactory {
    public Etat createEtat(int id) {
        Etat etat = new Etat();
        etat.setEtatId(id);
        return etat;
    }
}
