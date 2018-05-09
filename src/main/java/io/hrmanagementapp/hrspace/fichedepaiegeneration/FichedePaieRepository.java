package io.hrmanagementapp.hrspace.fichedepaiegeneration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichedePaieRepository extends MongoRepository<FichedePaie,String> {

}
