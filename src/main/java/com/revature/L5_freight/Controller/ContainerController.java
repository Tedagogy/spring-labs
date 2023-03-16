package com.revature.L5_freight.Controller;

import com.revature.L5_freight.Exceptions.InvalidTonnageException;
import com.revature.L5_freight.Model.Container;
import com.revature.L5_freight.Service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * there is no need to modify this class.
 */
@RestController
public class ContainerController {
    ContainerService containerService;
    @Autowired
    public ContainerController(ContainerService containerService){
        this.containerService = containerService;
    }

    /**
     * This endpoint to POST localhost:9000/container will take in an array of containers, rather than a single container,
     * in the request body. If all containers in the array were valid, they will be persisted and contained in the
     * response body. If any containers are for some reason invalid (such as if an InvalidTonnageException is thrown),
     * none of the containers will be persisted and the endpoint will respond with a 400 error thanks to the
     * @ExceptionHandler later in this controller. We'll assume that this is due to a user error by a shipping magnate
     * and data that contains invalid containers should be rolled back with the help of the @Transactional annotation
     * in the Service class.
     *
     * For instance, a request to POST localhost:9000/ship/1/container with the request body
     * [{
     *     "contents":"toys",
     *     "tonnage":4,
     * },
     * {
     *     "contents":"anvils",
     *     "tonnage":500
     * }]
     * should respond with
     * [{
     *     "contents":"toys",
     *     "tonnage":4,
     *     "ship": {"id":1,"name":"ever given","tonnage":100000}
     * },
     * {
     *     "contents":"anvils",
     *     "tonnage":500
     *     "ship": {"id":1,"name":"ever given","tonnage":100000}
     * }]
     *
     * @param containers
     * @return
     * @throws InvalidTonnageException
     */
    @PostMapping("ship/{id}/container")
    public List<Container> postManyContainers(@PathVariable long id, @RequestBody List<Container> containers) throws InvalidTonnageException {
        return containerService.addListContainers(id, containers);
    }
    @GetMapping("container")
    public List<Container> getAllContainers(){
        return containerService.getAllContainers();
    }
    @GetMapping("container/{id}")
    public Container getContainerById(@PathVariable long id){
        return containerService.getContainerById(id);
    }
    /**
     * letting spring know how to respond when any endpoint throws an InvalidTonnageException
     */
    @ExceptionHandler({InvalidTonnageException.class})
    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "invalid tonnage!"
    )
    public void handleInvalidTonnage() {
    }

}
