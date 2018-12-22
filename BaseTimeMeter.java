package com.gary.dida;

/**
 * @author gary
 *
 */
public abstract class BaseTimeMeter implements Runnable {
    public static final int DEFAULT_WAITTIME = 1000;
    private volatile boolean goon;
    private volatile int waitTime;
    private TimeMeterWorker worker;
    private Object lock;

    public BaseTimeMeter() {
        lock = new Object();
    }

    /**
     *
     */
    public abstract void running();
    public abstract void stopRunning();
    public abstract void itIsThTime();

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void stopTimeMeter() {
        goon = false;
    }

    public void startTimeMeter() {
        goon = true;
        worker = new TimeMeterWorker();
        new Thread(worker).start();
        synchronized (lock) {
            new Thread(this, "TimeWoker").start();
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
        }
        if (waitTime == 0) {
            waitTime = DEFAULT_WAITTIME;
        }
        running();
        while (goon) {
            synchronized (worker) {
                try {
                    worker.wait(waitTime);
                    worker.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        stopRunning();
    }

    public class TimeMeterWorker implements Runnable {

        public TimeMeterWorker() {
        }

        @Override
        public void run() {
            while (goon) {
                synchronized (this) {
                    try {
                        this.wait();
                        if (goon) {
                            itIsThTime();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
