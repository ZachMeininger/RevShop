package dev.meininger.RevShopApp.repository;

import dev.meininger.RevShopApp.entity.BuyerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerAccountRepository extends JpaRepository<BuyerAccount, Long>{

    BuyerAccount findBuyerAccountByUserId(long UserId);

    BuyerAccount findBuyerAccountByUserEmail(String UserEmail);

    BuyerAccount findBuyerAccountByUserEmailAndUserPassword(String UserEmail, String UserPassword);

    BuyerAccount findBuyerAccountBySecurityQuestionAndSecurityAnswer(String SecurityQuestion, String SecurityAnswer);
}
