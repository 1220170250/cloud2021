package com.qinkai.springcloud.controller;

import com.qinkai.springcloud.entities.CommonResult;
import com.qinkai.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    // 通过在eureka上注册过的微服务名称调用
    public static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_SRV + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SRV + "/payment/get/" + id, CommonResult.class, id);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_SRV + "/payment/zipkin/", String.class);
        return result;
    }
}

