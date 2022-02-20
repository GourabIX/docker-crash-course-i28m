package com.in28minutes.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_URI:http://localhost:8000}")
/*
 * When 'url' attribute is not specified in the @FeignClient annotation, it will automatically ask the
 * eureka-naming-server service registry for all the instances of "currency-exchange-service". 
 * The FeignClient includes "ribbon" as dependency, which is a client side load balancer. Ribbon will 
 * then automatically load balance requests across all the "currency-exchange-service" instances which 
 * were returned by the eureka-naming-server service registry.
 */
@FeignClient(name = "currency-exchange-service")

//@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	// @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}