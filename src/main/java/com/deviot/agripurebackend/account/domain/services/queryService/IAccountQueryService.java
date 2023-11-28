package com.deviot.agripurebackend.account.domain.services.queryService;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.deviot.agripurebackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.deviot.agripurebackend.account.domain.model.queries.GetSpecialistsQuery;

import java.util.List;

public interface IAccountQueryService {
    Account handle(GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery);
    Account handle(GetAccountByEmailQuery getAccountByEmailQuery);
    List<Account> handle(GetSpecialistsQuery getSpecialistsQuery);
}
