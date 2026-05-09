package utils;

public class validateAuth {

    public static boolean login(String username, String password){

        if( !lengthCheck(username, 6, 12) 
            || !lengthCheck(password, 6, 12)) {
                return false;
            }

        return true;
    }
    public static boolean register(String username, String password, String rePassword){

        if( !password.equals(rePassword) ) return false;

        if( !lengthCheck(username, 6, 12 ) 
            || !lengthCheck(password, 6, 12 )
            || !lengthCheck(rePassword, 6, 12 )) {
                return false;
            }

        return true;
    }

    private static boolean lengthCheck(String data, int start, int end){
        if( data.length() < start && data.length() > end ) {
            System.err.println("Your data "+ data +" should be "+ start + "-" + end + " characters");
            return false;
        }

        return true;
    }

}
