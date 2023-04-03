package com.damian.hms.service.impl;

import com.damian.hms.convertor.Convertor;
import com.damian.hms.dao.impl.LoginDetailsDAOIMPL;
import com.damian.hms.dao.util.DaoFactory;
import com.damian.hms.dao.util.DaoTypes;
import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.entity.LoginDetails;
import com.damian.hms.service.custom.LoginDetailsService;

import java.util.ArrayList;
import java.util.Optional;

public class LoginDetailsServiceImpl implements LoginDetailsService {

    @Override
    public boolean add(LoginDetails_DTO loginDetailsDto) {
        LoginDetailsDAOIMPL ldao = (LoginDetailsDAOIMPL) DaoFactory.getDao(DaoTypes.LoginDetailsDAO);
        return ldao.add(Convertor.convertLoginDetails_DTOToLoginDetails(loginDetailsDto));
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(LoginDetails_DTO loginDetailsDto, String s) {
        return false;
    }

    @Override
    public Optional<LoginDetails_DTO> search(String s) {
        LoginDetailsDAOIMPL dao = (LoginDetailsDAOIMPL) DaoFactory.getDao(DaoTypes.LoginDetailsDAO);
        if(dao.search(s).isPresent()){
           return Optional.of(Convertor.convertLoginDetailsToLoginDetails_DTO(dao.search(s).get()));
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<LoginDetails_DTO> getAll() {
        return null;
    }
}
