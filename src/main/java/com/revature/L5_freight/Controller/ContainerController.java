package com.revature.L5_freight.Controller;

import com.revature.L5_freight.Exceptions.InvalidTonnageException;
import com.revature.L5_freight.Model.Container;
import com.revature.L5_freight.Service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * By including a path in the RestController annotation, all endpoints written here will start with container -
 * eg localhost:9000/container/{id}
 */
@RestController
@RequestMapping("container")
public class ContainerController {
    ContainerService containerService;
    @Autowired
    public ContainerController(ContainerService containerService){
        this.containerService = containerService;
    }
    @PostMapping
    public void postManyContainers(@RequestBody List<Container> containers) throws InvalidTonnageException {
        containerService.addListContainers(containers);
    }
    @GetMapping
    public List<Container> getAllContainers(){
        return containerService.getAllContainers();
    }
    @GetMapping("{id}")
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
