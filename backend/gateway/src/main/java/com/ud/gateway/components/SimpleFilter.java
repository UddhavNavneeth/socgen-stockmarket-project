package com.ud.gateway.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class SimpleFilter implements GatewayFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger( SimpleFilter.class );
    private static final String COUNT_START_TIME = "countStartTime";
    private static String validationMessage;

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)  {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        byte[] bytes = err.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);

        return response.writeWith(Flux.just(buffer));
    }

    private Boolean isAuthorizationValid(String token) throws URISyntaxException {
        WebClient client = WebClient.create();
        Mono<String> response = client.get()
                .uri(new URI("http://localhost:8085/user/validate"))
                .header("token", token)
                .retrieve()
                .bodyToMono(String.class);

        return false;
//        return response.subscribe(str -> {
//            if (str.equals("user") || str.equals("admin")) {
//                return true;
//            } else {
//                return false;
//            }
//        });
//        HttpStatus status = response.getStatusCode();
//        return (this.validationMessage.equals("user") || this.validationMessage.equals("admin")) ? true : false;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (!request.getHeaders().containsKey("token")) {
            return this.onError(exchange, "No Authorization header", HttpStatus.UNAUTHORIZED);
        };

        String token = request.getHeaders().getFirst("token");

        try {
            if (!this.isAuthorizationValid(token)) {
                return this.onError(exchange, "Invalid Authorization header", HttpStatus.UNAUTHORIZED);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return chain.filter(exchange);
//                .then(
//                Mono.fromRunnable(() -> {
//                    long startTime = exchange.getAttribute(COUNT_START_TIME);
//                    long endTime=(Instant.now().toEpochMilli() - startTime);
//                    log.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
//                })
//        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
