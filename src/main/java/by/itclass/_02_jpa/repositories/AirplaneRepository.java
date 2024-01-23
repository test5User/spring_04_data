package by.itclass._02_jpa.repositories;

import by.itclass._02_jpa.entities.Airplane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
    //find, get, query, delete, update
    //By
    //Model, Place

    Airplane findByModel(String model);
    Airplane findByModelAndPlace(String model, int place);
    Airplane findByModelLikeAndPlace(String model, int place);
    Airplane findByModelLikeOrPlace(String model, int place);
    Airplane findByModelLike(String model);
    Airplane findByIdBetween(int start, int end);
    List<Airplane> findByPlaceBetween(int start, int end);

    @Query(value = "select * from airplane", nativeQuery = true)
    List<Airplane> allPlanes();

    @Query(value = "select * from airplane where model like ?1 and place > ?2", nativeQuery = true)
    List<Airplane> concretePlains(String model, int place);
}
