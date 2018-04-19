package cn.imzfz.model;

/**
 * Created by zfz on 2018/4/19.
 * 内存bean
 */


public class MemoryModel {
    private int maxMemory;
    private int totalMemory;
    private int freeMemory;

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }
}
