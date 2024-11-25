/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Controladores.utils.Response;
import Controladores.utils.Status;
import core.models.Bank;
import core.models.BasicAccount;
import core.models.User;
import core.validators.AccountValidator;
import core.validators.ValidationException;
import java.util.Random;

/**
 *
 * @author arang
 */
public class AccountService {

    private Bank bankModel;

    public AccountService(Bank bankModel) {
        this.bankModel = bankModel;
    }

    public Response createAccount(int userId, double initialBalance) throws ValidationException {
        // Buscar usuario
        User selectedUser = bankModel.getUserRepository().findById(userId);
        if (selectedUser == null) {
            return new Response("El usuario no existe en la plataforma.", Status.NOT_FOUND);
        }

        // Generar un ID para la cuenta
        String accountId = generateAccountId();

        // Crear y validar la cuenta
        BasicAccount newAccount = new BasicAccount(accountId, selectedUser, initialBalance);
        AccountValidator.validateAccount(newAccount, bankModel.getUserRepository(), bankModel.getAccountRepository());

        // Agregar la cuenta al repositorio
        bankModel.createAccount(newAccount);

        return new Response("Cuenta creada exitosamente.", Status.CREATED, newAccount);
    }

    private String generateAccountId() {
        Random random = new Random();
        return String.format("%03d-%06d-%02d",
                random.nextInt(1000), random.nextInt(1000000), random.nextInt(100));
    }
}
