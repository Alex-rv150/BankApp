/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import Controladores.utils.Response;
import core.models.BasicAccount;
import core.models.repository.AccountRepository;
import core.models.repository.UserRepository;

/**
 *
 * @author arang
 */
public interface AccountValidatorStrategy {
    Response validate(BasicAccount account, UserRepository userRepository, AccountRepository accountRepository) throws ValidationException;
}

