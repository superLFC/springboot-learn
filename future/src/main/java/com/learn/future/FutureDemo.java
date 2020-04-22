package com.learn.future;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Component
@Slf4j
public class FutureDemo implements ApplicationContextAware {

    @Resource(name = "threadPool")
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        test();
    }

    private void test() {
        Callable<String> call = () -> {
            log.info(Thread.currentThread().getName() + "   now is cooking");
            Thread.sleep(8000);
            return "Food is OK";
        };

        FutureTask<String> futureTask = new FutureTask<>(call);
        poolTaskExecutor.execute(futureTask);
        FutureTask<String> futureTask2 = new FutureTask<>(call);
        poolTaskExecutor.execute(futureTask2);


        log.info(Thread.currentThread().getName() + "   make Tea");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!futureTask.isDone()) {
            log.info(Thread.currentThread().getName() + "   Food is not ok");
        } else {
            try {
                String result = futureTask.get();
                log.info(Thread.currentThread().getName() + "   " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (futureTask2.isDone()) {
            try {
                String result = futureTask2.get();
                log.info(Thread.currentThread().getName() + "   " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
