package cn.imzfz.listener;


import org.springframework.web.context.ContextLoaderListener;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContextEvent;

import static org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext;

/**
 * Created by zfz on 2018/4/19.
 */

public class MyContextLoaderListener extends ContextLoaderListener {

    /**
     * 将所有的线程启动
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        @SuppressWarnings("unchecked")
        /**
         * @param threadMap cn.imzfz.thread pool
         */
                Map<String, Thread> threadMap = (Map<String, Thread>) getCurrentWebApplicationContext()
                .getBean("monitor");
        // start Threads
        Set<Entry<String, Thread>> threadMapEntrySet = threadMap.entrySet();
        for (Entry<String, Thread> threadMapEntry : threadMapEntrySet) {
            threadMapEntry.getValue().start();
        }
    }
}
