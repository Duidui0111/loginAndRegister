package shop.btwo.controller;

import cn.hutool.crypto.digest.DigestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.btwo.entity.User;
import shop.btwo.req.UserLoginReq;
import shop.btwo.req.UserSaveReq;
import shop.btwo.resq.CommonFalse;
import shop.btwo.resq.CommonTrue;
import shop.btwo.service.UserService;

import java.util.List;

/**
 * @author bangbang
 * @create 2023-04-07-9:44
 */

@CrossOrigin
//(origins = "http://43.154.115.125:9000")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public Object select(){
        List<User> list= userService.getUserList();
        return list;
    }

    @RequestMapping("/login")
    public Object getGoodsInfo(@RequestBody UserLoginReq req){
        try {
            if(req.getLoginName().length()< 6 || req.getPassword().length() <6){
                CommonFalse resp = new CommonFalse();
                return resp;
            }else {
                System.out.println(req);
                String MD5pwd = DigestUtil.md5Hex16(req.getPassword());
                User user= userService.getUserByLogin(req.getLoginName(),MD5pwd);
                if(user==null){
                    return null;
                }
                CommonTrue resp = new CommonTrue<>();
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
            CommonFalse resp = new CommonFalse();
            return resp;
        }


    }

    @RequestMapping("/register")
    public Object Register(@RequestBody UserSaveReq req){
            if(req.getLoginName().length()< 6 || req.getPassword().length() <6){
                CommonFalse resp = new CommonFalse();
                return resp;
            }else {
                User user = userService.getByLoginName(req.getLoginName());
                if(user!=null){
                    return null;
                }else{
                    String MD5pwd = DigestUtil.md5Hex16(req.getPassword());
                    int num = userService.insertUser(req.getLoginName(),req.getName(), MD5pwd);
                    CommonTrue resp = new CommonTrue();
                    return resp;
                }
            }
    }

    @RequestMapping("/updateUser")
    public Object updateUser(@RequestBody  UserSaveReq req){
        String MD5pwd = DigestUtil.md5Hex16(req.getPassword());
        int num = userService.updateUser(req.getLoginName(),req.getName(),MD5pwd,req.getId());
        System.out.println(num);
        return num;
    }

    @RequestMapping("/deleteUser")
    public Object deleteUser(@RequestBody UserSaveReq req){
        int num = userService.deleteUser(req.getId());
        return num;
    }
}
