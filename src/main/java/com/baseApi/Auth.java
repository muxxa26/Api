package com.baseApi;

import com.actions.HttpOperation;
import com.restassuredfunctions.Api;

public class Auth extends Api {


    public Auth() {
    }

    /**
     * Creates a new auth token to use for access to the PUT and DELETE /booking
     */
    private void createToken(String userName, String passWord) {
        initBase("Host");
        init("/auth", HttpOperation.POST);
        setHeader("Content-Type", "application/json");
        setBody("{ \"username\" : \"" + userName + "\", \"password\" : \"" + passWord + "\"}");
    }


    /**
     * @return returns login token
     * @param    userName (Username string value for the restful bokker application)
     * passWord (password string value for the restful bokker application)
     */
    public String getLoginToken(String userName, String passWord) {
        createToken(userName, passWord);
        String response = callIt();
        //System.out.println(response);
        return response;
    }
}



