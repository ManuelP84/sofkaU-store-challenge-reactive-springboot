package com.sofkaU.storeManagement.repository;

import com.sofkaU.storeManagement.collections.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends ReactiveMongoRepository<Bill, String> {
}
