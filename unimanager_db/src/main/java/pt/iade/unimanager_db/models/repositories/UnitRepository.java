package pt.iade.unimanager_db.models.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Unit;


public interface UnitRepository 
            extends CrudRepository<Unit,Integer> {
    Iterable<Unit> getUnits(Unit units);
    Iterable<Unit> findByName(String name);
    Iterable<Unit> findByNameLike(String name);
    Iterable<Unit> findByCreditsBetween(int min,int max);
    Iterable<Unit> findByNameLikeAndByCreditsBetween(String name,int min,int max);
	Optional<Unit> findById(int id);
    <S> S save(Unit unit);
	Iterable<Unit> deleteById(int id);
	Iterable<Unit> findByNameContaining(String text);
	Iterable<Unit> findByNameContainingAndCreditsBetween(String name, int _creditMin, int _creditMax);
}
    

