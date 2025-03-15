package edu.ncu.pay.demo.service.infos;

import edu.ncu.pay.demo.service.bos.PaymentOrderBO;
import edu.ncu.pay.demo.service.bos.TradeOrderBO;
import edu.ncu.pay.demo.service.bos.TradeRefundOrderBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TradeOrderInfo extends BaseOrderInfo {
    private TradeOrderMappingInfo tradeOrderMapping;
    private TradeOrderBO tradeOrder;
    private TradeRefundOrderBO refundOrder;
    private PaymentOrderBO paymentOrder;
}
