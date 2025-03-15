package edu.ncu.pay.demo.dao.mapper.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.ncu.pay.demo.dao.mapper.dos.PaymentOrderDO;
import edu.ncu.pay.demo.dao.mapper.dos.TradeOrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentOrderMapper extends BaseMapper<PaymentOrderDO> {
}
