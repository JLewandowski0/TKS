package appcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {
        "appcontroller.api",
        "appcontroller.adapters",
        "appcontroller.mappers",
        "appcontroller.modelDto",
        "services",
        "Repository",
        "RepoModel",
        "Adapters",
        "infrastructurePorts.BookPorts",
        "infrastructurePorts.RentPorts",
        "infrastructurePorts.UserPorts",
        "interfacePorts.BookPorts",
        "interfacePorts.RentPorts",
        "interfacePorts.UserPorts",
        "DomainMapper",
        "EntityMapper",
})
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
