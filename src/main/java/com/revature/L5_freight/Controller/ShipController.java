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
 *
 * there is no need to modify this class.
 */
@RestController
@RequestMapping("ship")
public class ShipController {
    ShipService shipService;
    @Autowired
    public ShipController(ShipService shipService){
        this.shipService = shipService;
    }

    /**
     * This endpoint to POST localhost:9000/ship will take in an array of ships, rather than a single ship, in the
     * request body. If all ships in the array were valid, they will be persisted and contained in the response body.
     * If any ships are for some reason invalid (such as if an InvalidTonnageException is thrown), none of the ships
     * will be persisted and the endpoint will respond with a 400 error thanks to the @ExceptionHandler later in this
     * controller. We'll assume that this is due to a user error by a shipping magnate and data that contains invalid
     * ships should be rolled back with the help of the @Transactional annotation in the Service class.
     *
     * For instance, a request to POST localhost:9000/ship with the request body
     * [{
     *     "name":"ever given",
     *     "tonnage":100000
     * },
     * {
     *     "name":"nautilis",
     *     "tonnage":5
     * }]
     * should respond with
     * [{
     *     "id":1
     *     "name":"ever given",
     *     "tonnage":100000
     * },
     * {
     *     "id":2
     *     "name":"nautilis",
     *     "tonnage":5
     * }]
     * @param ships
     * @return
     * @throws InvalidTonnageException
     */
    @PostMapping
    public List<Ship> postManyShips(@RequestBody List<Ship> ships) throws InvalidTonnageException {
        return shipService.addListShips(ships);
    }

    /**
     * Get all ships endpoint. For instance, a request to GET localhost:9000/ship could respond with
     * [{
     *     "id":1
     *     "name":"ever given",
     *     "tonnage":100000
     *     "containers":[]
     * },
     * {
     *     "id":2
     *     "name":"nautilis",
     *     "tonnage":5
     *     "containers":[]
     * }]
     * @return
     */
    @GetMapping
    public List<Ship> getAllContainers(){
        return shipService.getAllShips();
    }

    /**
     * Get ship by ID endpoint. For instance, a request to GET localhost:9000/ship/1 could respond with
     * {
     *     "id":1
     *     "name":"ever given",
     *     "tonnage":100000
     *     "containers":[]
     * }
     * @param id
     * @return
     */
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
