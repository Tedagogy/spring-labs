package com.revature.L5_freight.Service;

import com.revature.L5_freight.Exceptions.InvalidTonnageException;
import com.revature.L5_freight.Model.Container;
import com.revature.L5_freight.Repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The @Transactional annotation wraps every method in this class inside a database transaction, which is a set of
 * database statements that happen in isolation of all other database transactions. This means that multiple methods
 * of the class can run simultaneously (Spring is multithreaded) without having an effect such as a dirty read,
 * reading data that has been modified in an in-progress transaction. This matters when a Transaction has multiple
 * steps. (for instance, when a single transaction should process 100 database statements for purchasing items from a
 * user's cart, we don't want Spring to make the mistake of reading from an incomplete transaction, as e.g. a
 * request for the total cost of a user's cart could return an erroneous amount, such as only 50 items, if Spring
 * happens to read an incomplete transaction.) The @Transactional annotation is actually using Spring AOP to apply
 * the transaction start & commit to every method.
 *
 * You can test this by attempting to POST an array of containers where some container in the JSON has a negative
 * weight, then  attempting to get all ships. No ships should be POSTed if any container in the array has a negative
 * or zero weight - we're left to assume some form of unwanted user error in that case.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ContainerService {
    ContainerRepository containerRepository;
    @Autowired
    public ContainerService(ContainerRepository containerRepository){
        this.containerRepository = containerRepository;
    }
    /**
     * this is a bad way to save a list to the repository as you can just use the .saveAll method provided the table
     * has a CHECK constraint to check tonnage, but this gets the point across for the importance of @Transactional
     * @param containers transient container entities
     * @throws InvalidTonnageException ships can not have negative tonnage (they'd sink), containers can not have
     * negative weight (they'd fly away)
     */
    public void addListContainers(List<Container> containers) throws InvalidTonnageException {
        for(int i = 0; i < containers.size(); i++){
            if(containers.get(i).getWeight()<=0){
                throw new InvalidTonnageException();
            }
            containerRepository.save(containers.get(i));
        }
    }

    /**
     * @return all container entities
     */
    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }
    /**
     * @return container entities by id
     */
    public Container getContainerById(long id) {
        return containerRepository.findById(id).get();
    }
}