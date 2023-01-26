package pl.tks.brokerservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tks.brokerservice.dto.BookDto;
import pl.tks.brokerservice.dto.UserDto;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping(value = "/add-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public void get(@RequestBody UserDto userDto) {
        UserDto user = userDto;
        user.setUuid(UUID.randomUUID());
        rabbitTemplate.convertAndSend("amq.fanout","user",userDto);
    }

    @PostMapping(value = "/add-book", produces = MediaType.APPLICATION_JSON_VALUE)
    public void get(@RequestBody BookDto bookDto) {
        rabbitTemplate.convertAndSend("book",bookDto);
    }
}
