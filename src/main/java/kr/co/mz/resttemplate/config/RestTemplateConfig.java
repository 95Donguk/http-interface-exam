package kr.co.mz.resttemplate.config;

import kr.co.mz.resttemplate.api.ExchangeRateApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Configuration
public class RestTemplateConfig {
  @Bean
  ExchangeRateApi exchangeRateApi() {
    // 환율 정보 가져오는 오픈 API
    // https://open.er-api.com/v6/latest
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://open.er-api.com/"));

    // 메서드가 호출될 때 요청을 수행하는 프록시를 만들어야 합니다.
    RestTemplateAdapter adapter = RestTemplateAdapter.create(restTemplate);
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
    return factory.createClient(ExchangeRateApi.class);
  }
}
