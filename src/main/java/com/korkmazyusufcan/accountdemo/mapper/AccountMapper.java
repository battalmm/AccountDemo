package com.korkmazyusufcan.accountdemo.mapper;
import com.korkmazyusufcan.accountdemo.dto.AccountDto;
import com.korkmazyusufcan.accountdemo.model.Account;
import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private final CustomerMapper customerMapper;
    private final TransactionMapper transactionMapper;

    public AccountMapper(CustomerMapper customerMapper,
                         TransactionMapper transactionMapper) {
        this.customerMapper = customerMapper;
        this.transactionMapper = transactionMapper;
    }

    public AccountDto toDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerMapper.convertToAccountCustomer(Optional.ofNullable(account.getCustomer())),
                Objects.requireNonNull(account.getTransactionsList())
                        .stream()
                        .map(transactionMapper::toDto)
                        .collect(Collectors.toSet())
        );
    }
}
