package com.tuxdev.kontaweb.dao.db.interfaces.base;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by j.sanchez.chaves on 4/26/2018.
 *
 * KONTA-pom
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T,ID>,JpaSpecificationExecutor<T> {
    <S extends T> List<S> save(Iterable<S> entities);

    List<T> findAll();

    List<T> findAll(Sort sort);



}
