package com.fintech.gateway_pagamento;

import com.fintech.gateway.GatewayPagamentoApplication;
import org.springframework.boot.SpringApplication;

public class TestGatewayPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.from(GatewayPagamentoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
