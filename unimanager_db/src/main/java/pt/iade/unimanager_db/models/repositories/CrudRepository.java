package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CrudRepository<T,ID>
extends Repository<T,ID>{
    
}