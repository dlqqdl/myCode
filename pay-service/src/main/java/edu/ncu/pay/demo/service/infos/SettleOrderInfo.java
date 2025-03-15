package edu.ncu.pay.demo.service.infos;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.ncu.pay.demo.common.enums.SettleOrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SettleOrderInfo extends BaseOrderInfo {
    /**
     * 交易订单号
     */
    private String tradeOrderNo;
    /**
     * 结算订单号
     */
    private String settleOrderNo;
    /**
     * 结算状态
     */
    private SettleOrderStatus status;
    /**
     * 订单金额
     */
    private BigDecimal settleAmount;
    /**
     * 付款方
     */
    private String payerId;
    /**
     * 收款方
     */
    private String payeeId;
    /**
     * 分帐方
     */
    private List<String> splitIds;
}
