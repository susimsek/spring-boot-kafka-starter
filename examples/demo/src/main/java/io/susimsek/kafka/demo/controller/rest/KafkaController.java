package io.susimsek.kafka.demo.controller.rest;

import io.susimsek.kafka.demo.model.User;
import io.susimsek.kafka.demo.service.KafKaProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Users", description = "Retrieve and manage users")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(value = "/api/v1/kafka")
public class KafkaController {

    final KafKaProducerService producer;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Create User")
    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public User sendMessageToKafkaTopic(@Parameter(description = "User to be created") @Valid @RequestBody User user) {
        producer.saveCreateUserLog(user);
        return user;
    }
}