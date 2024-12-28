package ie.atu.yr4project_2;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <Task, Long>
{
}
