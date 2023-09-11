package dev.br.breno.springartemisconsumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HelloNameConsumer {
    @JmsListener(destination = "hello-name")
    public void consume(String name) {
        try {
            System.out.println("Olá " + name + ", Seja bem vindo a Amsterdam");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
