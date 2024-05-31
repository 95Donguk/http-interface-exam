package kr.co.mz.resttemplate;

import java.math.BigDecimal;
import java.util.Map;
import kr.co.mz.resttemplate.api.ExchangeRateApi;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class ResttemplateApplication {

  private final ExchangeRateApi api;

  public ResttemplateApplication(ExchangeRateApi api) {
    this.api = api;
  }

  @Bean
  ApplicationRunner init() {
    return args -> {
      Map<String, Map<String, BigDecimal>> res = api.getLatest();
      System.out.println("1USD = " + res.get("rates").get("KRW") + "WON");
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(ResttemplateApplication.class, args);
  }
}
