package by.itclass._02_jpa.repositories;

import by.itclass._02_jpa.entities.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
}
