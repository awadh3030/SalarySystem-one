package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObjects;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.Service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController {
@Autowired
    AccountService accountService;

//    @RequestMapping("account/create")
//    public void saveAccount (Account account) {
//       createAccount();
//   }

    @RequestMapping("account/create")
    public void saveAccount (@RequestBody GetAccountRequestObjects accountRequestObject) {
        createAccount(accountRequestObject);
    }
    @RequestMapping("account/get")
    public List<Account> getAccounts () {
        return accountService.getAccounts();
    }



    @RequestMapping("account/get/{accountId}")
    public GetAccountResponse createAccount (@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }


    public void createAccount(GetAccountRequestObjects accountRequestObject) {

        Account account = new Account();
        account.setBankName(accountRequestObject.getBankName());
        account.setAccountNumber(accountRequestObject.getAccountNumber());
        account.setBankBranch(accountRequestObject.getBankBranch());
        account.setSwiftCode("IT");
        account.setAccountHolderName("TechM");
        account.setAccountType("ok");
        account.setBranchCode(123);
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        accountService.saveAccount(account);





    }

    @GetMapping("account/query")
    @ResponseBody
    public String getaccountQueryString(@RequestParam String a,@RequestParam String b,@RequestParam String c) throws JsonProcessingException {
        Account account = new Account();
        account.setBankName(a);
        account.setAccountNumber(b);
        account.setBankBranch(c);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(accountService.getAccountAsString(account));
        System.out.print(s);
        return s;
    }


    @RequestMapping("account/delete/{accountId}")
    public void deleteeaccount (@PathVariable Long Id) {
        accountService.deleteAccountById(Id);
    }


}
