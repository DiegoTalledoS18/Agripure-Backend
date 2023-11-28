package com.deviot.agripurebackend.account.application.internal.QueryService;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.deviot.agripurebackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.deviot.agripurebackend.account.domain.model.queries.GetSpecialistsQuery;
import com.deviot.agripurebackend.account.domain.services.queryService.IAccountQueryService;
import com.deviot.agripurebackend.account.infrastructure.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountQueryService implements IAccountQueryService {
    private final AccountRepository accountRepository;

    @Override
    public Account handle(GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery){
        Optional<Account> account=accountRepository.findById(getEmailAndTypeByAccountIdQuery.accountId());
        if(account.isPresent()){
            return account.get();
        }
        else {
            return null;
        }
    }
    @Override
    public Account handle(GetAccountByEmailQuery getAccountByEmailQuery){
        Optional<Account> account= accountRepository.findByEmail(getAccountByEmailQuery.email());
        if (account.isPresent()){
            return account.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Account> handle(GetSpecialistsQuery getSpecialistsQuery){
        Optional<List<Account>> accounts=accountRepository.findAccountsByRol(getSpecialistsQuery.type());
        if (accounts.isPresent()){
            return accounts.get();
        }else {
            return null;
        }
    }
}
