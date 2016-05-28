package com.abin.lee.concurrent.common.hook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 16-5-20
 * Time: 下午11:22
 * To change this template use File | Settings | File Templates.
 */
public class ShutDownHook extends Thread {
    private  Logger LOGGER = LogManager.getLogger(this.getClass());
    @Override
    public void run() {
        LOGGER.info("准备退出router进程...");
        //TODO process before shutdown
        LOGGER.info("退出router进程...");
    }
}
