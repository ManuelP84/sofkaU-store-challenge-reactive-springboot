package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ReceiptOrderDto;
import com.sofkaU.storeManagement.usecases.GetAllReceiptOrdersUseCase;
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
public class GetAllReceiptOrdersRoute {

    @Bean
    @RouterOperation(path = "/v1/api/get/receipts", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetAllReceiptOrdersUseCase.class,
            method = RequestMethod.GET, beanMethod = "get",
            operation = @Operation(operationId = "getReceipts",
                    responses = {
                            @ApiResponse(responseCode = "200",
                                    description = "Successful operation",
                                    content = @Content(schema = @Schema(implementation = ReceiptOrderDto.class)))}
            ))

    public RouterFunction<ServerResponse> getAllReceiptOrdersRouter(GetAllReceiptOrdersUseCase getAllReceiptOrdersUseCase){
        return route(
                GET("/v1/api/get/receipts").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllReceiptOrdersUseCase.get(), ReceiptOrderDto.class))
        );
    }
}
