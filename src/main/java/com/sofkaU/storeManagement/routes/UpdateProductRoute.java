package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.usecases.UpdateProductUseCase;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {

    @Bean
    @RouterOperation(path = "/v1/api/update/product/", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.PUT,
            beanClass = UpdateProductUseCase.class,
            beanMethod = "apply",
            operation = @Operation(operationId = "updateProduct",
                    responses = {
                    @ApiResponse(responseCode = "202",
                            description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))),
                    @ApiResponse(responseCode = "400",
                            description = "Invalid product information")},
                    requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductDto.class)))
            ))

    RouterFunction<ServerResponse> updateProductsRoute(UpdateProductUseCase updateProductUseCase) {
        return route(
                PUT("/v1/api/update/product/").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(updateProductUseCase::apply)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
