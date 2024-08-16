package geovani.training.traininggs.config;

import geovani.training.traininggs.entity.Channel;
import geovani.training.traininggs.entity.Status;
import geovani.training.traininggs.repository.ChannelRepository;
import geovani.training.traininggs.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::getChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::getStatus)
                .forEach(statusRepository::save);
    }
}
