package shop.btwo.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import shop.btwo.entity.User;
import shop.btwo.mapper.UserMapper;
import shop.btwo.req.UserSaveReq;
import shop.btwo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bangbang
 * @create 2023-04-07-10:15
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByLogin(String loginName, String password) {
        return userMapper.getUserByLogin(loginName,password);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    public int insertUser(String loginName, String name, String password) {
        int num =  userMapper.insertUser(loginName,name,password);
        return num;
    }



    @Override
    public int updateUser(String loginName, String name,String password, int id) {
        int num =  userMapper.updateUser(loginName,name,password,id);
        return num;
    }

    @Override
    public int deleteUser(int id) {
        int num = userMapper.deleteUser(id);
        return num;
    }
}
