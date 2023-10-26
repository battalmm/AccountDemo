package com.korkmazyusufcan.accountdemo.controller;

import com.korkmazyusufcan.accountdemo.dto.AccountDto;
import com.korkmazyusufcan.accountdemo.dto.CreateAccountRequestDto;
import com.korkmazyusufcan.accountdemo.model.Account;
import com.korkmazyusufcan.accountdemo.service.AccountService;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server.port=0")
class AccountControllerTest {

    @MockBean
    private AccountService accountService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Ignore
    public void createAccountTest_WhenCreateAccountRequestDtoIsValid_shouldReturnAccountDto() throws Exception {
        Long customerId = 1L;
        BigDecimal initialCredit = BigDecimal.ZERO;
        CreateAccountRequestDto createAccountRequestDto = new CreateAccountRequestDto(customerId,initialCredit);

        AccountDto accountDto = new AccountDto();
        when(accountService.createAccount(createAccountRequestDto)).thenReturn(accountDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/account").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}