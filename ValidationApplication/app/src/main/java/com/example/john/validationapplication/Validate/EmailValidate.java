package com.example.john.validationapplication.Validate;

/**
 * Created by John on 22/08/2016.
 */
public class EmailValidate {

    public static boolean isValidEmail(String email) {

        if (email == null) {

            return false;

        } else {

            return android.util.Patterns.EMAIL_ADDRESS
                    .matcher(email).matches();
        }
    }
}
