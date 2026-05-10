package utils;

import dto.LoginRequest;
import dto.RegisterRequest;

public class validateAuth {

    public static boolean login(LoginRequest loginRequest){

        if( !lengthCheck(loginRequest.getUsername() , 6, 12) 
            || !lengthCheck(loginRequest.getPassword() , 6, 12)) {
                return false;
            }

        return true;
    }

    public static boolean register(RegisterRequest registerRequest){

        if( !registerRequest.getPassword().equals(registerRequest.getRePassword()) ) return false;

        if( !lengthCheck(registerRequest.getUsername(), 6, 12 ) 
            || !lengthCheck(registerRequest.getPassword(), 6, 12 )
            || !lengthCheck(registerRequest.getRePassword(), 6, 12 )) {
                return false;
            }

        return true;
    }

    private static boolean lengthCheck(String data, int start, int end){
        if( data.length() < start || data.length() > end ) {
            System.err.println("Your data "+ data +" should be "+ start + "-" + end + " characters");
            return false;
        }

        return true;
    }

}
