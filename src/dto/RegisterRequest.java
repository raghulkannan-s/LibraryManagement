package dto;

public class RegisterRequest {
    
    private String username;
    private String password;
    private String rePassword;

    public RegisterRequest(String username, String password, String rePassword) {
        this.username = username;
        this.password = password;
        this.rePassword = rePassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword(){
        return rePassword;
    }


}
