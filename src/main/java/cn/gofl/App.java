package cn.gofl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序入口，已jar包形式启动
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"cn.gofl.**.dao"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

