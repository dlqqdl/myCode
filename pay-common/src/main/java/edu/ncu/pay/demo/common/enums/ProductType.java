package edu.ncu.pay.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {

    /**
     * 支付
     */
    PAY,
    /**
     * 结算
     */
    SETTLE,
    /**
     * 代扣
     */
    DEDUCT,
    /**
     * 提现
     */
    WITHDRAW,
    /**
     * 转账
     */
    TRANSFER,
}
