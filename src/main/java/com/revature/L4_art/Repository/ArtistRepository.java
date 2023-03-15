package com.revature.L4_art.Repository;

import com.revature.L4_art.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Extending JPARepository<Entity class, ID datatype> grants this class the functionality of a JPARepository:
 * this means that this class will be capable of treating the provided entity as a Java Object that is mapped
 * to a database record automatically using a strategy called Object Relational Mapping.
 *
 * Spring provides any JPARepository with some automatically generated abilities, such as persisting with save(),
 * as well as some automatically generated methods for interacting with databases such as findAll() and findById().
 * These methods do not need to be implemented by the developer at all.
 *
 * A JPARepository also allows for the developer to write JPQL (Java Persistence Query Language), which allows for the
 * writing of queries that Spring JPARepository does not provide from the start. JPQL Queries are made for interacting
 * with ORM entities, and they follow the same format and use the same clauses as a typical SQL query, but rather
 * than starting with SELECT <columns> FROM <table> ... , they are written with the pattern FROM <entity class name> ...
 * because they abstract away the conversion of a ResultSet into a model class entirely. and do not require the SELECT
 * keyword. You can also find the syntax for adding parameters for the query below. (Spring also allows you to write
 * native SQL queries, or selecting columns with JPQL, if required.)
 *
 * This class will work like a Spring Component, but the @Component annotation is not needed here, because the class
 * is an interface. The implementation of JPARepository, which will be a component, will be generated at runtime.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    /**
     * Retrieve Artist entity(s) with nationality field matching the :nationality parameter using a JPQL query
     * @param nationality
     * @return A List of all Artist entities with nationality
     */
    @Query("FROM Artist WHERE nationality = :nationality")
    List<Artist> findArtistsByNationality(@Param("nationality") String nationality);
    /**
     * Spring is smart: JPARepositories can infer many types of queries based on the method name without
     * any need for an explicit JPQL query.
     * You can read about more of them here:
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
     * Until you need to write a very ornate query, these can fulfill all of your use cases.
     * @param name
     * @return A List of all Artist entities with a certain name
     */
    List<Artist> findArtistByName(String name);

}
