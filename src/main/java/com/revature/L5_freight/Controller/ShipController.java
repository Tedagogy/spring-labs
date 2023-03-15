package com.revature.L5_freight.Controller;

import com.revature.L5_freight.Exceptions.InvalidTonnageException;
import com.revature.L5_freight.Model.Container;
import com.revature.L5_freight.Model.Ship;
import com.revature.L5_freight.Service.ContainerService;
import com.revature.L5_freight.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * By including a path in the RestController annotation, all endpoints written here will start with ship -
 * eg localhost:9000/ship/{id}
 */
@RestController
@RequestMapping("ship")
public class ShipController {
    ShipService shipService;
    @Autowired
    public ShipController(ShipService shipService){
        this.shipService = shipService;
    }
    @PostMapping
    public void postManyShips(@RequestBody List<Ship> ships) throws InvalidTonnageException {
        shipService.addListShips(ships);
    }
    @GetMapping
    public List<Ship> getAllContainers(){
        return shipService.getAllShips();
    }
    @GetMapping("{id}")
    public Ship getContainerById(@PathVariable long id){
        return shipService.getShipById(id);
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
