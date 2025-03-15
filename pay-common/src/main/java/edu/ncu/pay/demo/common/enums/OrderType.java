package edu.ncu.pay.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {

    /**
     * 交易
     */
    TRADE,
    /**
     * 充值
     */
    DEPOSIT,
    /**
     * 提现
     */
    WITHDRAW,
    /**
     * 转账
     */
    TRANSFER,
}
