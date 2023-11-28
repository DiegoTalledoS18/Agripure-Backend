package com.deviot.agripurebackend.ccm.application.internal;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.deviot.agripurebackend.ccm.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.ccm.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.ccm.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.ccm.domain.services.INotificationsCommandService;
import com.deviot.agripurebackend.ccm.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationCommandService implements INotificationsCommandService {
    private final NotificationRepository notificationRepository;

    private String getCurrentFormattedDate() {
        // Obtener la fecha actual
        Date currentDate = new Date();

        // Formatear la fecha al formato deseado
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(currentDate);
    }
    @Override
    public String handle(CreateNotificationCommand createNotificationCommand) {
        String currentFormattedDate = getCurrentFormattedDate();
        Notification newNotification = Notification.builder()
                .message(createNotificationCommand.message())
                .imageUrl(createNotificationCommand.imageUrl())
                .notificationType(createNotificationCommand.notificationType())
                .date(currentFormattedDate)
                .toAccountId(createNotificationCommand.toAccountId())
                .plantId(createNotificationCommand.plantId())
                .fromAccountId(createNotificationCommand.fromAccountId())
                .seen(false)
                .build();
        if (notificationRepository.save(newNotification)!=null){
            return "Notification registered";
        }
        return "Can't registered your notification";

    }

    @Override
    public String handle(DeleteNotificationCommand deleteNotificationCommand) {

        Optional<Notification> notification = notificationRepository.findById(deleteNotificationCommand.id());
        if (!notification.isEmpty()){
            this.notificationRepository.deleteById(deleteNotificationCommand.id());
            return "Notification with id"+deleteNotificationCommand.id()+"was deleted";
        }
        return "Notification with id:"+ deleteNotificationCommand.id()+"doesnt exists";
    }

}
