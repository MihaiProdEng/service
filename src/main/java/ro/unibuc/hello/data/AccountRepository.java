package ro.unibuc.hello.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, String> {

    public List<AccountEntity> findAllByNameAndAndPassword(String name, String passwor);
    public List<AccountEntity> findAllByName(String name);
    @Transactional
    @Query("update AccountEntity a set a.name = ?1 where a.name = ?2")
    void changeName(String newName, String name);
}