package br.com.filipe.producer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Adicionando a anotação @Configuration
public class RabbitMQConfig {

    public static final String EXG_NAME_MARKETPLACE = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG = "product.log";
    public static final String RK_PRODUCT_LOG = "product.log"; // RK = Routing Key

    @Bean
    public Queue queue() {
        // Cria uma fila não durável, não exclusiva e não auto-deletável
        return new Queue(QUEUE_PRODUCT_LOG, false, false, false);
    }

    @Bean
    public DirectExchange directExchange() {
        // Cria uma exchange direta não durável e não auto-deletável
        return new DirectExchange(EXG_NAME_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding() {
        // Vincula a fila à exchange usando a routing key
        return BindingBuilder.bind(queue()) // Vincula a fila
                .to(directExchange())       // À exchange
                .with(RK_PRODUCT_LOG);      // Usando a routing key
    }
}