package com.stepDef;

import com.actions.ValidatorOperation;
import com.baseApi.Auth;
import com.interfaces.IAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

     private Auth response = new Auth();

    @When("I set {string} as UserName and I set {string} as a password")
    public void iSetAdminAsUserNameAndISetPasswordAsAPassword(String username,String password) {

        response.getLoginToken(username, password);
    }


    @Then("I signed in")
    public void iSignedIn() {
        response.assertIt(200);
        response.assertIt("token",null, ValidatorOperation.NOT_EMPTY);
        response.assertIt("token",null,ValidatorOperation.NOT_NULL);
    }


}
