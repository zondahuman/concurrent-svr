package com.abin.lee.concurrent.common.hook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 16-5-20
 * Time: 下午11:25
 * To change this template use File | Settings | File Templates.
 */
public class WorkerServer {
    private static Logger LOGGER = LogManager.getLogger(WorkerServer.class);
    //简单模拟干活的
    public static Timer timer = new Timer("job-timer");

    //计数干活次数
    public static AtomicInteger count = new AtomicInteger(0);

    /**
     * hook线程
     */
    public static class CleanWorkThread extends Thread{
        @Override
        public void run() {
            LOGGER.info("clean some work. start");
            timer.cancel();
            try {
                Thread.sleep(2 * 1000);//sleep 2s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("clean some work. end");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Log4j2ShutDownHook());
        //将hook线程添加到运行时环境中去
        Runtime.getRuntime().addShutdownHook(new CleanWorkThread());
        LOGGER.info("main class start ..... ");
        //简单模拟
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                count.getAndIncrement();
                System.out.println("doing job " + count);
                if (count.get() == 30) {  //干了10次退出
                    System.exit(0);
                }
            }
        }, 0, 2 * 1000);
        LOGGER.info("main class end ..... ");
    }
}
