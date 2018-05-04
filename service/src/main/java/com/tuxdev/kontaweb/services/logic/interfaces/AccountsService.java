package com.tuxdev.kontaweb.services.logic.interfaces;

import com.tuxdev.kontaweb.domain.request.RequestBean;
import com.tuxdev.kontaweb.domain.response.ServiceResponse;

/**
 * Created by j.sanchez.chaves on 4/26/2018.
 * Accenture
 * KONTA-pom
 */
public interface AccountsService {
    ServiceResponse createAccount(RequestBean requestBean);
    ServiceResponse getListAccounts(String query);
}
