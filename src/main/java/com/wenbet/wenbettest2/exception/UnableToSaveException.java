/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wenbet.wenbettest2.exception;

/**
 *
 * @author Roberto
 */
public class UnableToSaveException extends Exception{

    public UnableToSaveException() {
    }

    public UnableToSaveException(String string) {
        super(string);
    }

    public UnableToSaveException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public UnableToSaveException(Throwable thrwbl) {
        super(thrwbl);
    }

    public UnableToSaveException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
