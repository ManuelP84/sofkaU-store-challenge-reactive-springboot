package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.usecases.CreateProviderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProviderRoute {

    @Bean
    @RouterOperation(path = "/v1/api/save/provider/", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = CreateProviderUseCase.class,
            beanMethod = "apply",
            operation = @Operation(
                    operationId = "createProvider",
                    responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = ProviderDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid provider information")
                    },
                    requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProviderDto.class)))
            ))

    public RouterFunction<ServerResponse> createProviderRouter(CreateProviderUseCase createProviderUseCase){
        return route(
                    POST("/v1/api/save/provider/").and(accept(MediaType.APPLICATION_JSON)),
                    request -> request
                            .bodyToMono(ProviderDto.class)
                            .flatMap(createProviderUseCase::apply)
                            .flatMap(providerDto -> ServerResponse.status(HttpStatus.CREATED)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(providerDto))
        );
    }
}
