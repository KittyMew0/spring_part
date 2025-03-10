package com.example.sem4and3task.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.sem4and3task.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<Product, String> productToJsonTransformer() {
        return product -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(product);
            } catch (Exception e) {
                return "{}";
            }
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public MessageHandler fileWriter() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("C:/Users/Desktop/products.log"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
