package edu.ncu.pay.demo.service.bos;

import edu.ncu.pay.demo.common.bos.BO;
import lombok.Data;

import java.util.Date;

@Data
public class BaseOrderBO implements BO {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String extension;
}
