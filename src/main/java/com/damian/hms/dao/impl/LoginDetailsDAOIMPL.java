package com.damian.hms.dao.impl;

import com.damian.hms.dao.custom.LoginDetailsDAO;
import com.damian.hms.entity.LoginDetails;
import com.damian.hms.repository.LoginRepo;

import java.util.ArrayList;
import java.util.Optional;

public class LoginDetailsDAOIMPL implements LoginDetailsDAO {

    @Override
    public boolean add(LoginDetails loginDetails) {
        LoginRepo lr = new LoginRepo();
        return lr.add(loginDetails);
    }

    @Override
    public boolean update(LoginDetails loginDetails) {
        LoginRepo lr = new LoginRepo();
        return lr.update(loginDetails);
    }

    @Override
    public boolean delete(LoginDetails loginDetails) {
        return false;
    }

    @Override
    public Optional<LoginDetails>search(String s) {
        LoginRepo lr = new LoginRepo();
        return lr.search(s);

    }

    @Override
    public ArrayList<LoginDetails> getAll() {
        return null;
    }
}
