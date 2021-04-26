package com.wyz.test.copy.thread;

public interface SRejectedExecutionHandler {

    void rejectedExecution(Runnable r, SThreadPoolExecutor executor);
}
