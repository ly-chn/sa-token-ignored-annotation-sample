package kim.nzxy.satokenignoredannotationsample;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ly
 */
@SpringBootApplication
public class SaTokenIgnoredAnnotationSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenIgnoredAnnotationSampleApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
