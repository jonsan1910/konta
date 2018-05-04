package com.tuxdev.kontaweb.services.logic;

import com.tuxdev.kontaweb.dao.db.interfaces.AccountDAO;
import com.tuxdev.kontaweb.domain.persistence.Accounts;
import com.tuxdev.kontaweb.domain.request.RequestBean;
import com.tuxdev.kontaweb.domain.response.ServiceResponse;
import com.tuxdev.kontaweb.domain.utils.Utils;
import com.tuxdev.kontaweb.services.logic.interfaces.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j.sanchez.chaves on 4/26/2018.
 *
 * KONTA-pom
 */
@Service
public class AccountsServiceImpl implements AccountsService{

    @Autowired
    private AccountDAO accountDAO;


    @Override
    public ServiceResponse createAccount(RequestBean requestBean) {
        ServiceResponse serviceResponse=new ServiceResponse();
        Accounts accounts=new Accounts();
        accounts.setNumber(requestBean.getPayload().get("number").toString());
        accounts.setDescription(requestBean.getPayload().get("description").toString());

        accountDAO.save(accounts);
        Map<String,Object> result=new HashMap<>();
        result.put("account",accounts);
        serviceResponse.setResponseDescription(result);
        return serviceResponse;
    }

    @Override
    public ServiceResponse getListAccounts(String query) {
        //Map<String,String> mapquery=Utils.getValuesOfQuery(query);
        ServiceResponse serviceResponse=new ServiceResponse();
        List<Accounts> accounts=accountDAO.findByParentIsNull();
        Map<String,Object> result=new HashMap<>();
        result.put("accounts",accounts);
        serviceResponse.setResponseDescription(result);
        return serviceResponse;
    }
}
