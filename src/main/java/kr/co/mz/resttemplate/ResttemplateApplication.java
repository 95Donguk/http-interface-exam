package kr.co.mz.resttemplate;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class ResttemplateApplication {

  @Bean
  ApplicationRunner init() {
    return args -> {
        // 환율 정보 가져오는 오픈 API
        // https://open.er-api.com/v6/latest
        RestTemplate rt = new RestTemplate();
      Map<String, Map<String, BigDecimal>> res = rt.getForObject("https://open.er-api.com/v6/latest", Map.class);
      System.out.println("1USD = " + res.get("rates").get("KRW") + "WON");
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(ResttemplateApplication.class, args);
  }
}
