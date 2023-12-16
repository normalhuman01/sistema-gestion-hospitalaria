package org.aquiles.util.repositry;

import java.util.List;

public interface Repository<T, ID> {

  T save(T entity);

  List<T> saveAll(List<T> entities);

  T findById(ID id);

  List<T> findAll();

  void delete(T entity);

  void deleteAll();

  void deleteById(ID id);

}
