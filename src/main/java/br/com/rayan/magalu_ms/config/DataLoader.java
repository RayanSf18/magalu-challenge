package br.com.rayan.magalu_ms.config;

import br.com.rayan.magalu_ms.entities.Channel;
import br.com.rayan.magalu_ms.entities.Status;
import br.com.rayan.magalu_ms.repository.ChannelRepository;
import br.com.rayan.magalu_ms.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@AllArgsConstructor
@Configuration
public class DataLoader implements CommandLineRunner {

 private final ChannelRepository channelRepository;
 private final StatusRepository statusRepository;

 @Override
 public void run(String... args) throws Exception {

  Arrays.stream(Channel.Values.values())
   .map(Channel.Values::toChannel)
   .forEach(channelRepository::save);

  Arrays.stream(Status.Values.values())
   .map(Status.Values::toStatus)
   .forEach(statusRepository::save);

 }

}
