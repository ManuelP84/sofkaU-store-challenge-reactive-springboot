package com.sofkaU.storeManagement.routes;

import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.usecases.CreateProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProviderRoute {

    @Bean
    public RouterFunction<ServerResponse> createProviderRouter(CreateProviderUseCase createProviderUseCase){
        return route(
                    POST("/save/provider").and(accept(MediaType.APPLICATION_JSON)),
                    request -> request
                            .bodyToMono(ProviderDto.class)
                            .flatMap(providerDto -> createProviderUseCase.apply(providerDto))
                            .flatMap(providerDto -> ServerResponse.status(HttpStatus.CREATED)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(providerDto))
        );
    }
}
