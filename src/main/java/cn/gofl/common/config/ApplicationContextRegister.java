package cn.gofl.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ApplicationContextRegister.class);
    private static  ApplicationContext APPLICATION_CONTEXT;

    /**
     * 设置 spring 上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("ApplicationContext regidted-->{}",APPLICATION_CONTEXT);
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * 获取 spring 容器
     * @return
     */
    public static ApplicationContext getApplicationContext () {
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取 spring 容器里面的方法
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getBean (Class<T> type) {
        return APPLICATION_CONTEXT.getBean(type);
    }
}
