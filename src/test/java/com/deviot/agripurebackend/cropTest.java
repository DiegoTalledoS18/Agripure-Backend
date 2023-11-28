package com.deviot.agripurebackend;

import com.deviot.agripurebackend.crop.application.internal.CropCommandService;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.entities.Crop;
import com.deviot.agripurebackend.crop.infrastructure.CropRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
public class cropTest {
    private final CropCommandService cropCommandService;
    @Test
    public void testCreateCrop(){
        CreateCropCommand createCropCommand=new CreateCropCommand(1L,1L);
        cropCommandService.handle(createCropCommand);
    }
    @Test
    public void testCreateCrop2(){
        CreateCropCommand createCropCommand=new CreateCropCommand(1L,1L);
        cropCommandService.handle(createCropCommand);
    }
    @Test
    public void testCreateCrop3(){
        CreateCropCommand createCropCommand=new CreateCropCommand(1L,1L);
        cropCommandService.handle(createCropCommand);
    }
    @Test
    public void testCreateCrop4(){
        CreateCropCommand createCropCommand=new CreateCropCommand(1L,1L);
        cropCommandService.handle(createCropCommand);
    }

}
