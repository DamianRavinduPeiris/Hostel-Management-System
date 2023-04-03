package com.damian.hms.service.custom;

import com.damian.hms.dto.SuperDTO;
import com.damian.hms.entity.SuperEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface SuperService<T extends SuperDTO, ID> {
    boolean add(T t);

    boolean delete(ID id);

    boolean update(T t, ID id);

    Optional<T> search(ID id);

    ArrayList<T> getAll();
}
