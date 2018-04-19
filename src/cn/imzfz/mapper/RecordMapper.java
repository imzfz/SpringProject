package cn.imzfz.mapper;

import cn.imzfz.model.MemoryModel;
import cn.imzfz.model.Record;

/**
 * Created by zfz on 2018/4/18.
 */
public interface RecordMapper {
    void record(Record record);
    void addMemory(MemoryModel memoryModel);
}
