package com.watson.motocyclerentals.services;

/**
 * Created by Long on 2018/08/01.
 */

import java.util.List;

public interface Services<S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
