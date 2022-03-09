package com.tinlee.app.rest.Controller;

import com.tinlee.app.rest.Models.Transaction;
import com.tinlee.app.rest.Repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Transactions {
    @Autowired

    private TransactionRepo transactionRepo;
    @GetMapping(value = "/api/v1/transactions")

    public List<Transaction> getTransactions(){
         return transactionRepo.findAll();
    }

    @PostMapping(value = "api/v1/transactions")

    public ResponseEntity saveTransaction(@RequestBody Transaction transaction){
        try{
            if(transaction==null){
                return ResponseEntity.notFound().build();
            }
            transactionRepo.save(transaction);
            return ResponseEntity.ok().body("Transaction added successfully");
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping(value = "/api/v1/transaction/{id}")

    public ResponseEntity updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        try{
            if(transaction == null){
                return ResponseEntity.notFound().build();

            }
            Transaction updatedTran = transactionRepo.findById(id).get();
            updatedTran.setAmount(transaction.getAmount());
            transactionRepo.save(updatedTran);
            return ResponseEntity.ok().body("Transaction updated successfully");
        }catch(Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping(value = "/api/v1/transaction/{id}")

    public ResponseEntity getOneTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        try {

            if(transaction == null){
                ResponseEntity.notFound().build();
            }
            transaction = transactionRepo.findById(id).get();
            return ResponseEntity.ok().body(transaction);
        }catch (Exception e){
           return ResponseEntity.ok().body(e.getMessage());

        }
    }

    @DeleteMapping(value = "/api/v1/transaction/{id}")

    public ResponseEntity deleteTransaction(@PathVariable Long id, Transaction transaction) {
        try {
            if (transaction == null) {
                return ResponseEntity.notFound().build();
            }
            transaction = transactionRepo.findById(id).get();
            transactionRepo.delete(transaction);
            return ResponseEntity.ok().body("Transaction deleted successfully ..........");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
