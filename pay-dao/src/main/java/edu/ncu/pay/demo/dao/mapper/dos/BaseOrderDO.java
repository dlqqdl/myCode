package edu.ncu.pay.demo.dao.mapper.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import edu.ncu.pay.demo.common.dos.DO;
import lombok.Data;

import java.util.Date;

@Data
public class BaseOrderDO implements DO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String extension;
}
