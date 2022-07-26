package com.aabbcc.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    private static ThreadPoolTaskExecutor threadPoolTaskExecutor=null;
    static {
        threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 10);
        // 设置队列容量
        threadPoolTaskExecutor.setQueueCapacity(Runtime.getRuntime().availableProcessors() * 10);
        // 设置线程活跃时间（秒）
        threadPoolTaskExecutor.setKeepAliveSeconds(10);
        // 设置默认线程名称
        threadPoolTaskExecutor.setThreadNamePrefix("pic-");
        // 设置拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.initialize();
    }

    public static ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        return threadPoolTaskExecutor;
    }
}
