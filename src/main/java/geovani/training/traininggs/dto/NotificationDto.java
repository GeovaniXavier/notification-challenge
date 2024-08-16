package geovani.training.traininggs.dto;

import geovani.training.traininggs.entity.Channel;
import geovani.training.traininggs.entity.Notification;
import geovani.training.traininggs.entity.Status;

import java.time.LocalDateTime;

public record NotificationDto(LocalDateTime dateTime,
                              String message,
                              String destination,
                              Channel.Values channel) {
    public Notification toEntity() {
        return new Notification(dateTime, message, destination, channel.getChannel(), Status.Values.PENDING.getStatus());
    }
}
