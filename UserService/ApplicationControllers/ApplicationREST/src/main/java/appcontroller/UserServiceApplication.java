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
        "infrastructurePorts.UserPorts",
        "interfacePorts.UserPorts",
        "DomainMapper",
        "EntityMapper",})

public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
