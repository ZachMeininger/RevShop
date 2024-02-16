package dev.meininger.RevShopApp.service;

import dev.meininger.RevShopApp.entity.BuyerAccount;
import dev.meininger.RevShopApp.repository.BuyerAccountRepository;
import jakarta.transaction.Transactional;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class BuyerAccountService {
    @Autowired
    BuyerAccountRepository buyeraccountRepository;

    @Transactional
    public BuyerAccount addBuyerAccount(BuyerAccount buyeraccount)
    {
        if(buyeraccountRepository.findBuyerAccountByUserEmail(buyeraccount.getUserEmail()) == null)
        {
            return buyeraccountRepository.save(buyeraccount);
        }
        return null;
    }

    @Transactional
    public BuyerAccount loginBuyerAccount(BuyerAccount buyeraccount)
    {
        return buyeraccountRepository.findBuyerAccountByUserEmailAndUserPassword(buyeraccount.getUserEmail(), buyeraccount.getUserPassword());
    }

    @Transactional
    public BuyerAccount findBuyerAccountById(long id)
    {
        return buyeraccountRepository.findBuyerAccountByUserId(id);
    }
}
