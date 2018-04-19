package cn.imzfz.thread;

import cn.imzfz.model.MemoryModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.imzfz.mapper.RecordMapper;

/**
 * Created by zfz on 2018/4/19.
 */


public class MemThread extends Thread {
    private static final Logger logger = Logger.getLogger(MemThread.class);
    @Autowired
    RecordMapper recordMapper;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                MemoryModel memoryModel = new MemoryModel();
                memoryModel.setMaxMemory((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024));
                memoryModel.setTotalMemory((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024));
                memoryModel.setFreeMemory((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024));
                recordMapper.addMemory(memoryModel);
                logger.info("记录一次内存信息");
            } catch (InterruptedException e) {
                logger.error("ERROR", e);
            }
        }
    }

    public RecordMapper getRecordMapper() {
        return recordMapper;
    }

    public void setRecordMapper(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }
}
