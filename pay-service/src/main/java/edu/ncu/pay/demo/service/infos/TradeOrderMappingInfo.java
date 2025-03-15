package edu.ncu.pay.demo.service.infos;

import edu.ncu.pay.demo.common.enums.OrderType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TradeOrderMappingInfo extends BaseOrderInfo {
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
