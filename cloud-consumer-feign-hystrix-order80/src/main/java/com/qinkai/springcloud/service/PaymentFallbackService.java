package com.qinkai.springcloud.service;

import org.springframework.stereotype.Component;


@Component //必须加
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
}
