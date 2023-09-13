package com.korkmazyusufcan.accountdemo.controller;
import com.korkmazyusufcan.accountdemo.dto.AccountDto;
import com.korkmazyusufcan.accountdemo.dto.CreateAccountRequestDto;
import com.korkmazyusufcan.accountdemo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequestDto createAccountRequestDto){
        return ResponseEntity.ok(accountService.createAccount(createAccountRequestDto));
    }



}
