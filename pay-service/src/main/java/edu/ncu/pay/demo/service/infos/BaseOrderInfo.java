package edu.ncu.pay.demo.service.infos;

import edu.ncu.pay.demo.common.info.INFO;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseOrderInfo implements INFO {
    protected Long id;
    protected Date createTime;
    protected Date updateTime;
    protected String extension;
}
