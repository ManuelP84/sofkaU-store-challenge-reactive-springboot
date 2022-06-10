package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.usecases.CreateProductUseCase;
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
public class CreateProductRoute {

    @Bean
    @RouterOperation(path = "/v1/api/save/product/", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = CreateProductUseCase.class,
            beanMethod = "apply",
            operation = @Operation(
                    operationId = "createProduct",
                    responses = {
                            @ApiResponse(
                                    responseCode = "201",
                                    description = "Successful operation",
                                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid product information")
                    },
                    requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductDto.class)))
            ))

    public RouterFunction<ServerResponse> createProduct(CreateProductUseCase createProductUseCase){
        return route(
                POST("/v1/api/save/product/").and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                        .bodyToMono(ProductDto.class)
                        .flatMap(createProductUseCase::apply)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
        );
    }
}
