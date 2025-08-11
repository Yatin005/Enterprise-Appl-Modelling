package com.va.week10;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@RestController
@RequestMapping("/market")
public class MarketServiceController {

    private final MarketRepository repo;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public MarketServiceController(MarketRepository repo, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.repo = repo;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/process")
    public String processOrder(@RequestBody OrderDTO order) {
        Market mo = new Market();
        mo.setOrderId(order.getId());
        mo.setExecutedPrice(99.95);
        mo.setStatus("CONFIRMED");
        repo.save(mo);

        try {
            File file = new File("market-" + mo.getOrderId() + ".json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, mo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String acctUrl = "http://fee-service/fees/transaction";
        restTemplate.postForObject(acctUrl, mo, String.class);

        return "Order executed & sent to account service";
    }
}