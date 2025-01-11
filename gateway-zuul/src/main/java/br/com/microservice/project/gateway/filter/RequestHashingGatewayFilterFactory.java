package br.com.microservice.project.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

public class RequestHashingGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestHashingGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(RequestHashingGatewayFilterFactory.class);

    public RequestHashingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(final Config config) {
        return (exchange, chain) -> {
            // Pre-processing
            if (config.isPreLogger()) {
                log.info("Pre GatewayFilter logging: "
                        + config.getBaseMessage());
            }
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Post-processing
                        if (config.isPostLogger()) {
                            log.info("Post GatewayFilter logging: "
                                    + config.getBaseMessage());
                        }
                    }));
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("algorithm");
    }

    static class Config {

        private MessageDigest messageDigest;
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

        public MessageDigest getMessageDigest() {
            return messageDigest;
        }

        public void setMessageDigest(MessageDigest messageDigest) {
            this.messageDigest = messageDigest;
        }

        public void setAlgorithm(String algorithm) throws NoSuchAlgorithmException {
            messageDigest = MessageDigest.getInstance(algorithm);
        }

        public String getBaseMessage() {
            return baseMessage;
        }

        public void setBaseMessage(String baseMessage) {
            this.baseMessage = baseMessage;
        }

        public boolean isPreLogger() {
            return preLogger;
        }

        public void setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
        }

        public boolean isPostLogger() {
            return postLogger;
        }

        public void setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
        }
    }
}