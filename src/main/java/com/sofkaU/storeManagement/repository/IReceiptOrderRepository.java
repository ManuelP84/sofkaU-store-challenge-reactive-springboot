package com.sofkaU.storeManagement.repository;

import com.sofkaU.storeManagement.collections.ReceiptOrder;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptOrderRepository extends ReactiveMongoRepository<ReceiptOrder, String> {
}
