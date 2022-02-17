package com.example.bundesliga.service;

import com.example.bundesliga.dao.ErwartungDAO;

import com.example.bundesliga.model.Erwartung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class ErwartungServiceImpl implements ErwartungService{


    @Autowired
    private ErwartungDAO dao;

    @Override
    public Erwartung attach(Erwartung erwartung) {
        return dao.save(erwartung);
    }

    @Override
    public List<Erwartung> find() {
        List<Erwartung> tmp = dao.findAll();
        Collections.reverse(tmp);
              return  tmp;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Erwartung update(Erwartung erwartung) {
        return null;
    }
}
