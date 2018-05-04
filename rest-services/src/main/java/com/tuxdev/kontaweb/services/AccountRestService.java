package com.tuxdev.kontaweb.services;

import com.tuxdev.kontaweb.domain.request.RequestBean;
import com.tuxdev.kontaweb.domain.response.ServiceResponse;
import com.tuxdev.kontaweb.services.interfaces.AccountsTxn;
import com.tuxdev.kontaweb.services.logic.AccountsServiceImpl;
import com.tuxdev.kontaweb.services.logic.interfaces.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
@RestController
public class AccountRestService implements AccountsTxn {

    @Autowired
    private AccountsServiceImpl accountsService;

    @Override
    public ResponseEntity<ServiceResponse> addAccount(@RequestBody RequestBean body) {
        return new ResponseEntity<>(accountsService.createAccount(body), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServiceResponse> getAccounts(@RequestParam("query") String query) {
        return new ResponseEntity<>(accountsService.getListAccounts(query), HttpStatus.OK);
    }
}
