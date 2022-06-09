package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.usecases.GetAllProvidersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProvidersRoute {

    @Bean
    @RouterOperation(path = "/v1/api/get/provider", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetAllProvidersUseCase.class,
            method = RequestMethod.GET, beanMethod = "get",
            operation = @Operation(operationId = "getProviders",
                    responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = ProviderDto.class)))}
            ))
    public RouterFunction<ServerResponse> getAllProvidersRouter(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(
                GET("/v1/api/get/provider").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllProvidersUseCase.get(), ProviderDto.class))
        );
    }

}
