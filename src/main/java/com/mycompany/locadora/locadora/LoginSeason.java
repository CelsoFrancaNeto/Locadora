/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.locadora.locadora;

/**
 *
 * @author Celso Franca Neto
 */
public class LoginSeason {

    private boolean LoginSeason;
    private String usuario = "root";
    private String senha = "root";

    public LoginSeason() {
        this.LoginSeason = false;
    }

    public boolean fazerLogin(String usuario, String senha) {
        if (this.usuario.equals(usuario) && this.senha.equals(senha)) {
            return setLoginSeason(true);

        } else {
            return setLoginSeason(false);

        }
    }

    private boolean setLoginSeason(boolean valor) {
        return this.LoginSeason = valor;
    }
    
    public boolean getLoginSeason() {
        return LoginSeason;
    }
}
