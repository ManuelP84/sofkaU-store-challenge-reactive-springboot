package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ReceiptOrderDto;
import com.sofkaU.storeManagement.usecases.CreateReceiptOrderUseCase;
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
public class CreateReceiptOrderRoute {

    @Bean
    @RouterOperation(path = "/v1/api/save/receipt/", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = CreateReceiptOrderUseCase.class,
            beanMethod = "apply",
            operation = @Operation(
                    operationId = "createReceipt",
                    responses = {
                            @ApiResponse(
                                    responseCode = "201",
                                    description = "Successful operation",
                                    content = @Content(schema = @Schema(implementation = ReceiptOrderDto.class))),
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid receipt information")
                    },
                    requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ReceiptOrderDto.class)))
            ))

    public RouterFunction<ServerResponse> createReceiptOrderRouter(CreateReceiptOrderUseCase createReceiptOrderUseCase){
        return route(
                POST("/v1/api/save/receipt/").and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                        .bodyToMono(ReceiptOrderDto.class)
                        .flatMap(createReceiptOrderUseCase::apply)
                        .flatMap(receiptOrderDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptOrderDto))
        );
    }
}
