package dev.br.breno.springartemisconsumer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FileChange {
    @JmsListener(destination = "file-change")
    public void consume(String fileContent) {
        try {
            String filePath = "ARQUIVO_ALTERADO.txt";

            Files.write(Paths.get(filePath), fileContent.getBytes());

            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                line += " TUDO MENTIRA";
                lines.set(i, line);
            }
            Files.write(Paths.get(filePath), lines, StandardOpenOption.WRITE);

            System.out.println("Arquivo recebido e processado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
