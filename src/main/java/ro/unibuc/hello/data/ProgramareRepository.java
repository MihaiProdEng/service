package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgramareRepository extends MongoRepository<ProgramareEntity, String> {
    public List<ProgramareEntity> findAllByIdCont(String cont);
}
