package repository;

import domain.Entitate;
import domain.Event;

import java.util.Date;
import java.util.List;

public interface IRepository <T extends Entitate> {

    void adauga(T elem) throws Exception;

    T findId(int id);

    T sterge(T elem) throws Exception;

    T update (T elem) throws Exception;


    List<T> getAll();
}
