package edu.ncu.pay.demo.dao.mapper.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.ncu.pay.demo.common.enums.PayMethodType;
import edu.ncu.pay.demo.common.enums.PayOrderStatus;
import edu.ncu.pay.demo.common.enums.TradeOrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tb_trade_order")
public class TradeOrderDO extends BaseOrderDO {
    /**
     * 交易订单号
     */
    private String tradeOrderNo;
    /**
     * 交易状态
     */
    private TradeOrderStatus status;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 付款方
     */
    private String payerId;
    /**
     * 收款方
     */
    private String payeeId;
}
