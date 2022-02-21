package com.in28minutes.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Hardcoded @FeignClient name and url with port, when there's a single manual instance of currency exchange
 * service configured.
 */
//@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_URI:http://localhost:8000}")

/*
 * When 'url' attribute is not specified in the @FeignClient annotation, it will automatically ask the
 * eureka-naming-server service registry for all the instances of "currency-exchange-service". 
 * The FeignClient includes "ribbon" as dependency, which is a client side load balancer. Ribbon will 
 * then automatically load balance requests across all the "currency-exchange-service" instances which 
 * were returned by the eureka-naming-server service registry.
 */
//@FeignClient(name = "currency-exchange-service")

/*
 * The currency conversion service should not directly invoke the currency exchange service. The request
 * should go through the Zuul API gateway server instead.
 */
@FeignClient(name = "netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

	/*
	 * Commented after addition of netflix zuul API gateway server.
	 */
	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	/*
	 * Zuul API gateway server receives a request, and extracts the first part of the request URI (in this case,
	 * "currency-exchange-service"). It then makes a request for available instance details for the extracted
	 * service name to Eureka naming server. Then it would forward the request to the respective service instance.
	 */
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
