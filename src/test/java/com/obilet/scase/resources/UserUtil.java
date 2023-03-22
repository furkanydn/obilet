package com.obilet.scase.resources;

import java.util.Random;

public class UserUtil {
    private static final String[] EMAILEXT = {"@obilet.com","@mail.com","@destek.obilet.com","@bilet.com","@aydin.com"};
    private static final String[] USEREXT = {"aysegul","beyza","eftal","furkan","gunbay"};

    public static DCUser generateUser(){
        Random RN = new Random();
        int randomEmailExtNumber = RN.nextInt(EMAILEXT.length) +1 ;
        int randomUserName = RN.nextInt(USEREXT.length) +1;

        var email = USEREXT[randomUserName] + RN.nextInt(999) + EMAILEXT[randomEmailExtNumber];
        var pass = String.format("%06d", RN.nextInt(999999));
        var User = new DCUser();
        User.setEmail(email);
        User.setPassword(pass);
        return User;
    }
}
