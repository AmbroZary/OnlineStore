package common.Repositories;

import common.Repositories.CommonRepository;
import common.Interfaces.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonTestRepository<T extends Entity> implements CommonRepository<T> {

    protected List<T> list;

    public CommonTestRepository() {
        this.list = new ArrayList<T>();
    }

    @Override
    public void insert(T element) {
        list.add(element);
    }

    @Override
    public void delete(int id) {
        if(!list.removeIf((T e) -> e.getId() == id)){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T find(int id) {
        return list.stream()
                .filter((T e) ->e.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public void update(T element) {
            list = list.stream().filter((T e) -> e.getId() == element.getId()).map(e -> element).collect(Collectors.toList());
    }
}
