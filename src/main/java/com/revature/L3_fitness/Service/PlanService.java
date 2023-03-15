package com.revature.L3_fitness.Service;

import com.revature.L3_fitness.Model.Plan;
import com.revature.L3_fitness.Model.Workout;
import com.revature.L3_fitness.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The @Service annotation is a stereotype annotation. This means that the @Service annotation, like the @Controller,
 * the @RestController, and the @Repository annotations, are all specialized @Component annotations. @Service, however,
 * does not significantly differ from @Component, and is just used for the logical organization of the project.
 *
 * TODO: implement the Service methods below by interacting with the PlanRepository's built in methods.
 * Logging isn't necessary, but it is a good practice.
 */
@Service
public class PlanService {
    PlanRepository planRepository;
    @Autowired
    public PlanService(PlanRepository planRepository){
        this.planRepository = planRepository;
    }
    /**
     * TODO: return all plans from the PlanRepository
     * @return all Plan entities
     */
    public List<Plan> getAllPlan(){
        return null;
    }

    /**
     * TODO: persist a new plan
     * @param plan transient Plan entity
     * @return the persisted Plan entity
     */
    public Plan addPlan(Plan plan){
        return null;
    }
    /**
     * TODO: return a plan of a specific ID from the PlanRepository
     * @return the persisted Plan entity of a specific id
     */
    public Plan getPlanById(long id){
        return null;
    }
    /**
     * TODO: return the workout entity associated with a certain Plan
     */
    public Workout getWorkoutOfPlan(long id){
        return null;
    }
    /**
     * TODO: delete a plan entity using its ID and return the deleted workout
     */
    public Plan deletePlan(long id){
        return null;
    }
    /**
     * TODO: update a Plan's reps by retrieving the Plan entity with id, and using the reps field in updatedPlan to
     * update the entity.
     */
    public Plan updatePlanReps(long id, Plan updatedPlan){
        return null;
    }
}
