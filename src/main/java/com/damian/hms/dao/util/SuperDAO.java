package com.damian.hms.dao.util;

import com.damian.hms.entity.SuperEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface SuperDAO <T extends SuperEntity,ID>{
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
   Optional <T> search(ID id);
    ArrayList<T> getAll();
}
