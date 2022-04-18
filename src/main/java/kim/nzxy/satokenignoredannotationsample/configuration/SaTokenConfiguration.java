package kim.nzxy.satokenignoredannotationsample.configuration;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.strategy.SaStrategy;
import kim.nzxy.satokenignoredannotationsample.SaIgnoredLoginCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ly
 */
@Configuration
@Slf4j
public class SaTokenConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 重写一下SaAnnotationInterceptor类,
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (handler instanceof HandlerMethod) {
                    Method method = ((HandlerMethod) handler).getMethod();
                    // 忽略权限验证, 方法或者类上添加此注解, 则不需要权限验证
                    if (method.isAnnotationPresent(SaIgnoredLoginCheck.class) || method.getDeclaringClass().isAnnotationPresent(SaIgnoredLoginCheck.class)) {
                        log.info("接口因SaTokenIgnored被忽略鉴权: {}", method);
                        return true;
                    }
                    StpUtil.checkLogin();
                    SaStrategy.me.checkMethodAnnotation.accept(method);
                }
                return true;
            }
        }).addPathPatterns("/**");
    }
}