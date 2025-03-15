package edu.ncu.pay.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayMethodType {
    /**
     * 支付宝支付
     */
    ALI_PAY,
    /**
     * 微信支付
     */
    WX_PAY,
    /**
     * 银行卡支付
     */
    BANK_CARD_DEBIT,
    /**
     * 信用卡支付
     */
    BANK_CARD_CREDIT,
    /**
     * 掌银支付
     */
    ONLINE_BANK,
    /**
     * 余额
     */
    BALANCE,
}
