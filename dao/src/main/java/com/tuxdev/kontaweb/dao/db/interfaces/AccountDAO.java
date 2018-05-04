package com.tuxdev.kontaweb.dao.db.interfaces;

import com.tuxdev.kontaweb.dao.db.interfaces.base.MyRepository;
import com.tuxdev.kontaweb.domain.persistence.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
@Transactional
public interface AccountDAO extends MyRepository<Accounts,Integer> {
    List<Accounts> findByParentIsNull();
}
