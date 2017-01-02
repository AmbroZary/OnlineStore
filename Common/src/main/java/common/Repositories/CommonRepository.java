package common.Repositories;

import common.Interfaces.Entity;

import java.util.List;

public interface CommonRepository<T extends Entity> {
    void insert(T element);
    void delete(int id);
    T find(int id);
    List<T> findAll();
    void update(T element);
}
