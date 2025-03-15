package edu.ncu.pay.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeOrderStatus {
    /**
     * 初始化
     */
    INIT,
    /**
     * 处理中
     */
    PROCESS,
    /**
     * 成功
     */
    SUCCESS,
    /**
     * 失败
     */
    FAILED,
    /**
     * 关单
     */
    CLOSED,
}
