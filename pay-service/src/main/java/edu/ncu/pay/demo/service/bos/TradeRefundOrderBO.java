package edu.ncu.pay.demo.service.bos;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.ncu.pay.demo.common.enums.TradeOrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tb_trade_refund_order")
public class TradeRefundOrderBO extends BaseOrderBO {
    /**
     * 原交易订单号
     */
    private String originTradeOrderNo;
    /**
     * 交易订单号
     */
    private String tradeOrderNo;
    /**
     * 交易状态
     */
    private TradeOrderStatus status;
    /**
     * 订单退款金额
     */
    private BigDecimal refundAmount;
    /**
     * 订单优惠退款金额
     */
    private BigDecimal refundDiscountAmount;
}
