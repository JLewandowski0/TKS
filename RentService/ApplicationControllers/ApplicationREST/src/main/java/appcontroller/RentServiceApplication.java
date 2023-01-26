package appcontroller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
@EnableRabbit
public class RentServiceApplication {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    public static void main(String[] args) {
        SpringApplication.run(RentServiceApplication.class, args);
    }
}
