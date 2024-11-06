/*
    Aufgabe 4) Password - Entropieberechnung
*/

import java.util.Random;

public class Aufgabe4 {

    public static void main(String[] args) {

        int passwordLength = 10;
        String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int seed = 0;
        Random myRand = new Random(seed);

        String password = "";

        String passwordStrength = "";
        for(int i = 0; i < passwordLength; i++){
            password += characterSet.charAt(myRand.nextInt(characterSet.length()));
        }

        if(calculateEntropy(password) < 60){
            passwordStrength = "weak";
        }
        else if((calculateEntropy(password) < 120) && (calculateEntropy(password) >= 60)){
            passwordStrength = "strong";
        }
        else{
            passwordStrength = "very strong";
        }

        System.out.println("The generated password is: " + password);
        System.out.println("The entropy of the password is: " + calculateEntropy(password) + " -> The password is: " + passwordStrength);

    }

    private static double calculateEntropy(String password) {
        double l = password.length();
        double n = 0;
        double entropy = 0;
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                hasDigit = true;
            }
            if(Character.isUpperCase(password.charAt(i))){
                hasUpperCase = true;
            }
            if(Character.isLowerCase(password.charAt(i))){
                hasLowerCase = true;
            }
        }

        if(hasDigit && hasUpperCase && hasLowerCase){
            n = 62;
        }
        else if(hasUpperCase && hasLowerCase && !hasDigit){
            n = 52;
        }
        else if((hasUpperCase && !hasLowerCase && hasDigit) || (!hasUpperCase && !hasLowerCase && hasDigit)){
            n = 36;
        }
        else if((!hasUpperCase && hasLowerCase && !hasDigit) || (hasUpperCase && !hasLowerCase && !hasDigit)){
            n = 26;
        }
        else{
            n = 10;
        }

        entropy = l * (Math.log10(n)/Math.log10(2));
        return entropy; //Zeile kann geändert oder entfernt werden.
    }
}
