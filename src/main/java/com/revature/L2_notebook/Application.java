package notebook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Spring Boot is an additional project of Spring that enables automatic configuration of the project. It introduces
 * the @SpringBootApplication annotation, which combines the functionality of @ComponentScan, @Configuration
 * as well as @EnableAutoConfiguration.
 * Now we can automatically create beans by scanning the package for components, as well run all the Controller
 * classes on startup. Manually defining beans using the @Bean annotation is not necessary in this class.
 *
 * (the 'exclude' portion is there to prevent Spring Boot from trying to autoconfigure a database connection.)
 *
 * There is no need to change anything in this class.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {
    /**
     * Set up a logfile - now that we're using API rather than console output, you want to log everything your
     * HTTP server does, don't you?
     *
     * When another class uses Application.log.info, it's actually just referencing this static Object in this class.
     */
    public static Logger log = LogManager.getLogger();

    /**
     * Because Spring Boot has autoconfigured our application for us, the main method only requires a single
     * line: SpringApplication.run
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
