/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

/**
 *
 * @author arang
 */
public class ValidationException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje de error.
     * 
     * @param message El mensaje que describe el error de validación.
     */
    public ValidationException(String message) {
        super(message);
    }
}

