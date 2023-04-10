package shop.btwo.service;

import org.springframework.stereotype.Component;
import shop.btwo.entity.User;
import shop.btwo.req.UserSaveReq;

import java.util.List;

/**
 * @author bangbang
 * @create 2023-04-07-10:14
 */
@Component
public interface UserService {

    //根据账号和密码查询用户信息
//    User queryUserByloginNameAndPassword(String loginName, String password);

//    List<User> getUserList();


    User getUserByLogin(String loginName, String password);

    User getByLoginName(String loginName);

    int insertUser(String loginName, String name, String password);

    List<User> getUserList();

//    int updateUser(UserSaveReq req);

    int updateUser(String loginName, String name, String password, int id);

    int deleteUser(int id);
}
