package pt.iade.unimanager_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager_db.models.Unit;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;
import pt.iade.unimanager_db.models.repositories.UnitRepository;
import pt.iade.unimanager_db.models.results.SimpleResult;


@RestController
@RequestMapping(path="/api/units")
public class UnitController {
    private Logger logger = LoggerFactory.
    getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;
    @GetMapping(path ="",produces= MediaType.
    APPLICATION_JSON_VALUE)
    public Iterable<Unit> getUnits() { return getUnits();
}

@GetMapping(path = "/{id:[0-9]+}",produces= MediaType.
APPLICATION_JSON_VALUE)
public Unit getUnit(@PathVariable int id) {
    logger.info("Sending unit with id "+id);
    Optional<Unit> _unit=unitRepository.findById(id);
    if (_unit.isEmpty()) throw
        new NotFoundException(""+id,"Unit","id");
    else return _unit.get() ;
}

@PostMapping(path ="",produces= MediaType.
APPLICATION_JSON_VALUE)
public Unit saveUnit(@RequestBody Unit unit) {
Unit savedUnit = unitRepository.save(unit);
logger.info("Saving unit with id "+savedUnit.getId());
return savedUnit;
}

@DeleteMapping(path = "/{id:[0-9]+}", produces= MediaType.
APPLICATION_JSON_VALUE )
public SimpleResult deleteUnit(@PathVariable int id){
    logger.info("Deleting unit with id "+id);
    // No verification to see if it exists
    unitRepository.deleteById(id);
    return new SimpleResult("Deleted unit with id "+id+
        " (if id does not exists nothing was deleted)",
        null);
}

@GetMapping(path = "/{text:[^0-9]+}", produces= MediaType.
APPLICATION_JSON_VALUE )
public Iterable<Unit> getUnit(
    @PathVariable(value = "text") String text) {
    logger.info("Unit with name like "+text);
    return unitRepository.findByNameContaining(text);
} 

@GetMapping(path = "/search", produces= MediaType.
APPLICATION_JSON_VALUE )
public Iterable<Unit> searchUnits(
@RequestParam(value="name",defaultValue="") String name,
@RequestParam(value="creditsMin",defaultValue="min")String creditsMin,
@RequestParam(value="creditsMax",defaultValue="max")String creditsMax) {
    logger.info("Sending unit with name like "+name+" and credits between "+creditsMin+" and "+creditsMax);
    int _creditMin = -1;
    int _creditMax = Integer.MAX_VALUE;
    try { _creditMin = Integer.parseInt(creditsMin);
    } catch (NumberFormatException e) {}
    try { _creditMax = Integer.parseInt(creditsMax);
    } catch (NumberFormatException e) {}
    return unitRepository.findByNameContainingAndCreditsBetween
                        (name, _creditMin, _creditMax);
} 
}
