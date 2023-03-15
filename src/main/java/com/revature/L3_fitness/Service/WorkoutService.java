package com.revature.L3_fitness.Service;

import com.revature.L3_fitness.Application;
import com.revature.L3_fitness.Model.Plan;
import com.revature.L3_fitness.Model.Workout;
import com.revature.L3_fitness.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The @Service annotation is a stereotype annotation. This means that the @Service annotation, like the @Controller,
 * the @RestController, and the @Repository annotations, are all specialized @Component annotations. @Service, however,
 * does not significantly differ from @Component, and is just used for the logical organization of the project.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */
@Service
public class WorkoutService {
    WorkoutRepository workoutRepository;
    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
        Application.log.info("WorkoutService: Autowired the WorkoutService class - ready to go");
    }
    /**
     * Use the findAll method, which is provided by all Spring Data JPARepositories, to get all workouts.
     * @return all workouts
     */
    public List<Workout> getAllWorkout(){
        List<Workout> workoutList = workoutRepository.findAll();
        Application.log.info("WorkoutService: returning all workouts: "+workoutList);
        return workoutList;
    }
    /**
     * Use the save method, which is provided by all Spring Data JPARepositories, to save a workout.
     * @param workout a transient (unpersisted) workout Entity
     * @return a persistent (connected with the database) workout entity
     */
    public Workout addWorkout(Workout workout){
        Workout persistedWorkout = workoutRepository.save(workout);
        Application.log.info("WorkoutService: saving a workout: "+workout);
        return persistedWorkout;
    }
    /**
     * Use the findById method, which is provided by all Spring Data JPARepositories, to retrieve a workout by its ID.
     * The JPARepository returns an Optional when using findById, because it is unknown whether the Workout actually
     * exists.
     * @param id id of a Workout entity
     * @return a persistent (connected with the database) workout entity
     */
    public Workout getWorkoutById(long id){
        Optional<Workout> workoutOptional = workoutRepository.findById(id);
        Workout workout = workoutOptional.get();
        Application.log.info("WorkoutService: Getting workout by ID: "+id+", "+workout);
        return workoutOptional.get();
    }
    /**
     * Use the workout entity to retrieve the plans of a workout. Because Workout is a JPA entity managed by Spring Data,
     * using the getter method to retrieve a Workout's plans will automatically retrieve associated Plan entities.
     *
     * @param id the id of a Workout entity
     * @return all Plan entities associated with the Workout entity
     */
    public List<Plan> getWorkoutPlans(long id){
        Workout workout = getWorkoutById(id);
        List<Plan> plans = workout.getPlans();
        Application.log.info("WorkoutService: Getting plans of workout id: "+id+", "+plans);
        return plans;
    }
    /**
     * Use the remove method, which is provided by all Spring Data JPARepositories, to delete an entity.
     * The JPARepository returns an Optional when using findById, because it is unknown whether the Workout actually
     * exists.
     * @param id the id of a Workout entity
     * @return the workout entity which has been deleted from the database
     */
    public Workout deleteWorkout(long id){
        Optional<Workout> workoutOptional = workoutRepository.findById(id);
        Workout workout = workoutOptional.get();
        workoutRepository.delete(workout);
        Application.log.info("WorkoutService: deleting workout of ID: "+id+" which was: "+workout);
        return workout;
    }
    /**
     * Use the save method, which is provided by all Spring Data JPARepositories, to save changes made to an entity.
     * The JPARepository returns an Optional when using findById, because it is unknown whether the Workout actually
     * exists.
     * @param id the id of a Workout entity
     * @param newWorkout a Workout object containing only the fields to be updated (title)
     * @return the persistent & updated Workout object
     */
    public Workout updateWorkoutTitle(long id, Workout newWorkout){
        Optional<Workout> workoutOptional = workoutRepository.findById(id);
        Workout workout = workoutOptional.get();
        workout.setTitle(newWorkout.getTitle());
        workoutRepository.save(workout);
        Application.log.info("Updated workout of ID: "+id+", which is now: "+workout);
        return workout;
    }
}
