/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.Service;

/**
 *
 * @author apprentice
 */
public class InsuffecientSupplyException extends Exception {
    public InsuffecientSupplyException (String message) {
        super(message);
    }
}
