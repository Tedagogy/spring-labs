package com.revature.L3_fitness.Service;

import com.revature.L3_fitness.FitnessApplication;
import com.revature.L3_fitness.Model.Plan;
import com.revature.L3_fitness.Model.Workout;
import com.revature.L3_fitness.Repository.PlanRepository;
import com.revature.L3_fitness.Repository.WorkoutRepository;
import com.revature.L5_freight.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: implement the Service methods below by interacting with the PlanRepository's built in methods.
 * Logging isn't necessary, but it is a good practice.
 */
@Component
public class PlanService {
    PlanRepository planRepository;
    WorkoutRepository workoutRepository;
    @Autowired
    public PlanService(PlanRepository planRepository, WorkoutRepository workoutRepository){
        this.planRepository = planRepository;
        this.workoutRepository = workoutRepository;
    }
    /**
     * Persist a new plan and return the persisted plan. This is provided for you to allow you to test your API.
     * @param plan transient Plan entity
     * @return the persisted Plan entity
     */
    public Plan addPlan(long workoutId, Plan plan){
        Workout workout = workoutRepository.findById(workoutId).get();
        workout.getPlans().add(plan);
        return planRepository.save(plan);
    }
    /**
     * TODO: return all plans from the PlanRepository
     * @return all Plan entities
     */
    public List<Plan> getAllPlan(){
        return planRepository.findAll();
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
        Plan plan = planRepository.findById(id).get();
        Workout w = plan.getWorkout();
        FitnessApplication.log.info("get workout: "+plan + w);
        return w;
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
