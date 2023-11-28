package com.deviot.agripurebackend.advisory.interfaces.rest;

import com.deviot.agripurebackend.advisory.application.internal.contact.ContactCommandService;
import com.deviot.agripurebackend.advisory.application.internal.contact.ContactQueryService;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.CreateContactCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.DeleteContactCommand;
import com.deviot.agripurebackend.advisory.domain.model.commands.contact.StartChatCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Contact;
import com.deviot.agripurebackend.advisory.domain.model.queries.contact.GetContactByIdQuery;
import com.deviot.agripurebackend.advisory.domain.model.queries.contact.GetContactsByFarmerIdQuery;
import com.deviot.agripurebackend.advisory.domain.model.queries.contact.GetContactsBySpecialistIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    private final ContactCommandService contactCommandService;
    private final ContactQueryService contactQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createContact(@RequestBody CreateContactCommand createContactCommand){
        this.contactCommandService.handle(createContactCommand);
        return ResponseEntity.ok("Contact created!!");
    }
    @CrossOrigin
    @GetMapping("/contactById/{contactId}")
    public ResponseEntity<?> getContactById(@PathVariable("contactId") Long contactId){
        GetContactByIdQuery getContactByIdQuery=new GetContactByIdQuery(contactId);
        Contact contact=this.contactQueryService.handle(getContactByIdQuery);
        if(contact!=null){
            return ResponseEntity.ok(contact);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/contactByFarmerId/{farmerId}")
    public ResponseEntity<?> getContactByFamerId(@PathVariable("farmerId") Long farmerId){
        GetContactsByFarmerIdQuery getContactsByFarmerIdQuery=new GetContactsByFarmerIdQuery(farmerId);
        List<Contact> contacts=this.contactQueryService.handle(getContactsByFarmerIdQuery);
        if(contacts!=null){
            return ResponseEntity.ok(contacts);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/contactBySpecialistId/{specialistId}")
    public ResponseEntity<?> getContactByFarmerId(@PathVariable("specialistId") Long specialistId){
        GetContactsBySpecialistIdQuery getContactsBySpecialistIdQuery=new GetContactsBySpecialistIdQuery(specialistId);
        List<Contact> contacts=this.contactQueryService.handle(getContactsBySpecialistIdQuery);
        if(contacts!=null){
            return ResponseEntity.ok(contacts);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @DeleteMapping(("/deleteContactById/{contactId}"))
    public ResponseEntity<?> deleteContactById(@PathVariable("contactId") Long contactId){
        DeleteContactCommand deleteContactCommand=new DeleteContactCommand(contactId);
        String message=this.contactCommandService.handle(deleteContactCommand);
        return ResponseEntity.ok(message);
    }
    @CrossOrigin
    @PutMapping("/startChatForContact/{id}")
    public ResponseEntity<?> startChatForProject(@PathVariable("id") Long id){
        StartChatCommand startChatCommand=new StartChatCommand(id);
        String message=this.contactCommandService.handle(startChatCommand);
        return ResponseEntity.ok(message);
    }
}
