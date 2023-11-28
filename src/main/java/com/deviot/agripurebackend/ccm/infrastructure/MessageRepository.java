package com.deviot.agripurebackend.ccm.infrastructure;

import com.deviot.agripurebackend.ccm.domain.model.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findMessageByContactId(Long contactId);
}
