package kim.nzxy.satokenignoredannotationsample;

import java.lang.annotation.*;

/**
 * 添加此注解表示该字段不会被提取到token校验中
 * @author ly
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SaIgnoredLoginCheck {
}
