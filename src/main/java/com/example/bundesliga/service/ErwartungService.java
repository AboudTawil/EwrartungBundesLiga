package com.example.bundesliga.service;

import com.example.bundesliga.model.Erwartung;

import java.util.List;

public interface ErwartungService {

    Erwartung attach(Erwartung erwartung);

    List<Erwartung> find();

    void remove(int id);

    Erwartung update(Erwartung erwartung);

}
