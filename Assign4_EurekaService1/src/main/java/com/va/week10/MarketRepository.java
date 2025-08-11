package com.va.week10;


import org.springframework.data.mongodb.repository.MongoRepository;


public interface MarketRepository extends MongoRepository<Market, String> {}