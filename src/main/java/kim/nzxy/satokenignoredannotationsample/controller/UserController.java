package kim.nzxy.satokenignoredannotationsample.controller;

import cn.dev33.satoken.stp.StpUtil;
import kim.nzxy.satokenignoredannotationsample.SaIgnoredLoginCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 测试登录，浏览器访问： http://localhost:8080/user/doLogin?username=zhang&password=123456
     */
    @RequestMapping("doLogin")
    @SaIgnoredLoginCheck
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    @GetMapping("check-login")
    public String checkLogin() {
        return "反正就是需要登录才能访问";
    }

    @GetMapping("check-ignore-login")
    @SaIgnoredLoginCheck
    public String checkIgnoreLogin() {
        return "那么这个就不需要登录了";
    }

}