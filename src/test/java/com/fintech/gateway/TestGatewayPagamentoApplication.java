package com.fintech.gateway;

import com.fintech.gateway.GatewayPagamentoApplication;
import com.fintech.gateway.TestcontainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestGatewayPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.from(GatewayPagamentoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
