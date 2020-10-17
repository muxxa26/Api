package com.stepDef;

import com.actions.ValidatorOperation;
import com.baseApi.Auth;
import io.cucumber.java.en.Then;

public class Negative {
    Auth response = new Auth();
    @Then("I'm not sign in")
    public void iMNotSignIn() {
        try {
            response.assertIt(200);
            response.assertIt("reason","Bad credentials", ValidatorOperation.EQUALS);
        } catch (NullPointerException e){
            System.out.println("null pointer e");
        }

    }
}
