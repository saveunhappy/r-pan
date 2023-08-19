package com.imooc.pan.server;

import com.imooc.pan.core.constants.RPanConstants;
import com.imooc.pan.core.response.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = RPanConstants.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = RPanConstants.BASE_COMPONENT_SCAN_PATH)
@EnableAsync
@Slf4j
@RestController
@Api("测试")
public class RPanServerLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RPanServerLauncher.class);
        printStartLog(applicationContext);
    }

    @GetMapping("hello")
    public R<String> hello(String name){
        return R.success("hello" +name +"1");
    }


    /**
     * 打印启动日志
     *
     * @param applicationContext
     */
    private static void printStartLog(ConfigurableApplicationContext applicationContext) {
        String serverPort = applicationContext.getEnvironment().getProperty("server.port");
        String serverUrl = String.format("http://%s:%s", "127.0.0.1", serverPort);
        log.info(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, "r pan server started at: ", serverUrl));
        if (checkShowServerDoc(applicationContext)) {
            log.info(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, "r pan server's doc started at:", serverUrl + "/doc.html"));
        }
        log.info(AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, "r pan server has started successfully!"));
    }

    /**
     * 校验是否开启了接口文档
     *
     * @param applicationContext
     * @return
     */
    private static boolean checkShowServerDoc(ConfigurableApplicationContext applicationContext) {
        return applicationContext.getEnvironment().getProperty("swagger2.show", Boolean.class, true) && applicationContext.containsBean("swagger2Config");
    }

}
