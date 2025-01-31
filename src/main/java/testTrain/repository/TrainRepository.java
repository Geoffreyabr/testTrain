package testTrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testTrain.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

}
