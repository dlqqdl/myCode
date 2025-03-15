package edu.ncu.pay.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayOrderStatus {
    /**
     * 初始化
     */
    INIT,
    /**
     * 提交支付
     */
    COMMIT,
    /**
     * 成功
     */
    SUCCESS,
    /**
     * 失败
     */
    FAILED,
    /**
     * 撤销
     */
    REVOKED,
}
