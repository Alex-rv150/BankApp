/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import core.models.Account;
import core.models.UserRepository;

/**
 *
 * @author arang
 */
public class AccountValidator {

    public static void validateAccount(Account account, UserRepository   userRepository){
        
        if (account.getBalance() < 0) {
            throw new ValidationException("El saldo inicial no puede ser inferior a 0.");
        }
        
        ValidatorUserExits.validateUSersExits(userRepository, account.getOwner());
        
        

}
}


