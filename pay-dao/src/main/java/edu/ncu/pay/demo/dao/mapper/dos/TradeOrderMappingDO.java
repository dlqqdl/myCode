package edu.ncu.pay.demo.dao.mapper.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.ncu.pay.demo.common.enums.OrderType;
import edu.ncu.pay.demo.common.enums.TradeOrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tb_trade_order_mapping")
public class TradeOrderMappingDO extends BaseOrderDO {
    /**
     * 外部请求单号
     */
    private String outerRequestNo;
    /**
     * 交易订单号
     */
    private String tradeOrderNo;
    /**
     * 交易类型
     */
    private OrderType orderType;
}
