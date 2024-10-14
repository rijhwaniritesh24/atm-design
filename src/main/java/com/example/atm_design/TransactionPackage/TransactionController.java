package com.example.atm_design.TransactionPackage;

import com.example.atm_design.FailureDetectionPackage.FailureDetectionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atm")
@RequiredArgsConstructor
public class TransactionController {


    private final TransactionService transactionService;

    @GetMapping("/customers/total")
    public Map<String, Long> getTotalCustomers(@RequestHeader("token") String token) {
        /***
         *
         * TODO: validate token first after that perform task or return 401 error

         **/



        List<TransactionEntity> transactions = transactionService.getTransactionsInLast24Hours();
        long totalCustomers = transactions.stream().map(TransactionEntity::getCustomerId).distinct().count();
        return Map.of("total_customers", totalCustomers);
    }

    @GetMapping("/transactions/breakdown")
    public Map<String, Long> getTransactionBreakdown(@RequestHeader("token") String token) {

        /***
         *
         * TODO: validate token first after that perform task or return 401 error

         **/


        List<TransactionEntity> transactions = transactionService.getTransactionsBreakdown();
        long deposits = transactions.stream().filter(t -> t.getType().equals("deposit")).count();
        long withdrawals = transactions.stream().filter(t -> t.getType().equals("withdrawal")).count();
        long balanceChecks = transactions.stream().filter(t -> t.getType().equals("balance")).count();
        return Map.of("deposit", deposits, "cash_withdrawal", withdrawals, "balance_inquiry", balanceChecks);
    }
}
