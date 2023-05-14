package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController {
@Autowired
    AccountService accountService;

    @RequestMapping("account/create")
    public void saveAccount (Account account) {
        createAccount();
    }

    @RequestMapping("account/get")
    public List<Account> getAccounts () {
        return accountService.getAccounts();
    }


    public void createAccount() {

        Account account = new Account();
        account.setBankName("Abdullah");
        account.setAccountNumber("234565");
        account.setBankBranch("awadh");
        account.setSwiftCode("IT");
        account.setAccountHolderName("TechM");
        account.setAccountType("ok");
        account.setBranchCode(123);
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        accountService.saveAccount(account);





    }




}
