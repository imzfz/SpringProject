package cn.imzfz.model;

/**
 * Created by zfz on 2018/4/17.
 */
public class Record {
    private String operationID;
    private String operationIP;
    private String operation;
    private String result;

    public Record() {
    }



    public Record(String operationID, String operationIP, String operation, String result) {
        this.operationID = operationID;
        this.operationIP = operationIP;
        this.operation = operation;
        this.result = result;
    }

    public String getOperationID() {
        return operationID;
    }

    public void setOperationID(String operationID) {
        this.operationID = operationID;
    }

    public String getOperationIP() {
        return operationIP;
    }

    public void setOperationIP(String operationIP) {
        this.operationIP = operationIP;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
