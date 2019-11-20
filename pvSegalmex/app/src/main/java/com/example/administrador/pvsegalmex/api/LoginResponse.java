package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("authToken")
    @Expose
    private String authToken;
    @SerializedName("usuario")
    @Expose
    private Login login;

    public LoginResponse() {
        message = "";
        authToken = "";
        login = new Login();
    }

    public static LoginResponse instance = new LoginResponse();

    public final void clear() {
        message = "";
        authToken = "";
        login = new Login();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
