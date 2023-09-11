package dev.br.breno.springartemisconsumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CalcConsumer {
    @JmsListener(destination = "calc")
    public void consume(String jsonMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonMessage);

            float x = jsonNode.get("x").floatValue();
            float y = jsonNode.get("y").floatValue();
            float soma = x + y;

            System.out.println("A soma é: " + soma);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
