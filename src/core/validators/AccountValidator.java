/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;


import core.models.BasicAccount;
import core.models.repository.AccountRepository;
import core.models.repository.UserRepository;


/**
 *
 * @author arang
 */
public class AccountValidator {
    private static AccountValidatorStrategy strategy = new BasicAccountValidator();

    public static void setStrategy(AccountValidatorStrategy newStrategy) {
        strategy = newStrategy;
    }

    public static void validateAccount(BasicAccount account, UserRepository userRepository, AccountRepository accountRepository) throws ValidationException {
        strategy.validate(account, userRepository, accountRepository);
    }
}
