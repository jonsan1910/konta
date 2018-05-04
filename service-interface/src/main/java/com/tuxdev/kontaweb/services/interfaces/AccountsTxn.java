package com.tuxdev.kontaweb.services.interfaces;

import com.tuxdev.kontaweb.domain.request.RequestBean;
import com.tuxdev.kontaweb.domain.response.ServiceResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
@Api(value="Accounts")
public interface AccountsTxn {
    @ApiOperation(value = "", notes = "save account", response = ServiceResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success response", response = ServiceResponse.class),
            @ApiResponse(code = 500, message = "unexpected error", response = ServiceResponse.class)})
    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/rest/accounts/AddAccount")
    ResponseEntity<ServiceResponse> addAccount(@RequestBody RequestBean body);


    @ApiOperation(value = "", notes = "get accounts by query", response = ServiceResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success response", response = ServiceResponse.class),
            @ApiResponse(code = 500, message = "unexpected error", response = ServiceResponse.class)})
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/rest/accounts/list")
    ResponseEntity<ServiceResponse> getAccounts(@ApiParam(value = "query") @RequestParam("query") String query);
}
