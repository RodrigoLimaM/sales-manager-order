package br.com.salesmanager.order.repository;

import br.com.salesmanager.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {

    @Override
    <S extends Order> S insert(S s);
}
