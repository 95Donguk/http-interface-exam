package kr.co.mz.resttemplate.api;

import java.util.Map;
import org.springframework.web.service.annotation.GetExchange;

public interface ExchangeRateApi {
  @GetExchange("/v6/latest")
  Map getLatest();
}
