package edu.ncu.pay.demo.dao.mapper.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.ncu.pay.demo.dao.mapper.dos.SettleOrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettleOrderMapper extends BaseMapper<SettleOrderDO> {
}
