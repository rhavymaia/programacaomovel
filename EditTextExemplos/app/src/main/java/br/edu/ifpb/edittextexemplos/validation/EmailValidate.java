package br.edu.ifpb.edittextexemplos.validation;

/**
 * Created by Rhavy on 15/08/2016.
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
