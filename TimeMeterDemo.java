package com.gary.dida;

public class TimeMeterDemo extends BaseTimeMeter {
    private volatile int count;
    private String name;

    public TimeMeterDemo(String name, int waitTime) {
        this.name = name;
        setWaitTime(waitTime);
    }

    @Override
    public void stopTimeMeter() {
        super.stopTimeMeter();
    }

    @Override
    public void startTimeMeter() {
        count = 0;
        super.startTimeMeter();
    }

    @Override
    public void running() {
        System.out.println(TimeUtil.timeString("开始工作"));
    }

    @Override
    public void stopRunning() {
        System.out.println(TimeUtil.timeString("停止工作"));
    }

    @Override
    public void itIsThTime() {
        System.out.println(TimeUtil.timeString("线程" + name
                + "：第" + ++count + "次工作！"));
    }
}
