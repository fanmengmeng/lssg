package com.lssg.common.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * spring boot 容器加载后自动监听
 * 执行 tokenThread 线程
 *
 * @author       fanrui
 * @version      1.0
 * @date         2018/9/20  16:57
 */

@Component
public class ThreadRunner implements CommandLineRunner {
    @Autowired
    private HkTokenThread tokenThread;

    @Override
    public void run(String... args) {
        new Thread(tokenThread).start();
    }
}
