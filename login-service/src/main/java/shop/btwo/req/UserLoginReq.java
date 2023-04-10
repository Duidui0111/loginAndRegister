package shop.btwo.req;

/**
 * @author bangbang
 * @create 2023-04-07-14:14
 */
public class UserLoginReq {

    private String loginName;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
