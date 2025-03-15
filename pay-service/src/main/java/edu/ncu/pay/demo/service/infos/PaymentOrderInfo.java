package edu.ncu.pay.demo.service.infos;

import edu.ncu.pay.demo.common.enums.PayMethodType;
import edu.ncu.pay.demo.common.enums.PayOrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentOrderInfo extends BaseOrderInfo {
    /**
     * 交易订单号
     */
    private String tradeOrderNo;
    /**
     * 支付订单号
     */
    private String paymentOrderNo;
    /**
     * 支付方式
     */
    private PayMethodType payMethod;
    /**
     * 支付状态
     */
    private PayOrderStatus status;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
}
