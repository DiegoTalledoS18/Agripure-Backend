package com.deviot.agripurebackend.advisory.application.internal.contact;

import com.deviot.agripurebackend.advisory.domain.Services.contact.IContactCommandService;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.CreateContactCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.DeleteContactCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.StartChatCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Contact;
import com.deviot.agripurebackend.advisory.infrastructure.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactCommandService implements IContactCommandService {
    private final ContactRepository contactRepository;

    @Override
    public String handle(CreateContactCommand createContactCommand){
        Contact newContact=Contact.builder()
                .farmerId(createContactCommand.farmerId())
                .specialistId(createContactCommand.specialistId())
                .isChatStarted(createContactCommand.isChatStarted())
                .build();
        contactRepository.save(newContact);
        return "Contact created!!";
    }

    @Override
    public String handle(DeleteContactCommand deleteContactCommand){
        Optional<Contact> contact=contactRepository.findById(deleteContactCommand.contactId());
        if(contact.isPresent()){
            contactRepository.deleteById(deleteContactCommand.contactId());
            return "Contact deleted!!";
        }
        else{
            return "Contact with the given id doesn't exist";
        }
    }

    @Override
    public String handle(StartChatCommand startChatCommand){
        Optional<Contact> contact=contactRepository.findById(startChatCommand.id());
        if(contact.isPresent()){
            contact.get().setIsChatStarted(true);
            contactRepository.save(contact.get());
            return "Chat started";
        }
        else{
            return "contact with the given id doesn't exist";
        }
    }



}
