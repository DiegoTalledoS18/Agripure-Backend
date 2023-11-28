package com.deviot.agripurebackend.kms.application;

import com.deviot.agripurebackend.kms.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.kms.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.kms.domain.model.commands.DeletePlantCommand;
import com.deviot.agripurebackend.kms.domain.model.commands.GenerateSeedCommand;
import com.deviot.agripurebackend.kms.domain.services.IPlantCommandService;
import com.deviot.agripurebackend.kms.infrastructure.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantCommandService implements IPlantCommandService {
    private final PlantRepository plantRepository;

    @Override
    public String handle(GenerateSeedCommand generateSeedCommand) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = """
                {
                    "plants": [
                      {
                      "id": 1,
                      "name": "Cabbage",
                      "scientificName": "Brassica oleracea var",
                      "imageUrl": "https://media.istockphoto.com/id/1341385091/photo/cabbage-cultivation-close-up.webp?b=1&s=170667a&w=0&k=20&c=HduVWYvfC3B_57LGowVTgGkYKSAXUVFJdGdyG4e4wW8=",
                      "variety": "Brassica oleracea",
                      "landType": "Loamy soil",
                      "weatherConditions": "Cool and moist",
                      "distanceBetweenPlants": "12 inches",
                      "idealPlantingDepth": "1/4 inch",
                      "fertilizationAndFumigation": "Organic compost and natural pest repellents",
                        "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 6.5
                      },
                      {
                      "id": 2,
                      "name": "Tomato",
                      "scientificName": "Solanum lycopersicum",
                      "imageUrl": "https://www.almanac.com/sites/default/files/styles/or/public/image_nodes/tomatoes_helios4eos_gettyimages-edit.jpg?itok=AFHF0CtR",
                      "variety": "Cherry Tomato",
                      "landType": "Loamy soil",
                      "weatherConditions": "Warm and sunny",
                      "distanceBetweenPlants": "18 inches",
                      "idealPlantingDepth": "1/4 inch",
                      "fertilizationAndFumigation": "Organic compost and natural pesticides",
                        "minTemperature": 15,
                        "maxTemperature": 30,
                        "minHumidity": 50,
                        "maxHumidity": 85,
                        "pH": 6.0
                    },
                    {
                      "id": 3,
                      "name": "Carrot",
                      "scientificName": "Daucus carota subsp. sativus",
                      "imageUrl": "https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2021/04/23175719/shutterstock_440493100-1.jpg",
                      "variety": "Nantes",
                      "landType": "Sandy soil",
                      "weatherConditions": "Mild temperatures",
                      "distanceBetweenPlants": "2 inches",
                      "idealPlantingDepth": "1/4 inch",
                      "fertilizationAndFumigation": "Well-rotted compost and neem oil",
                      "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 6.0
                    },
                    {
                      "id": 4,
                      "name": "Lettuce",
                      "scientificName": "Lactuca sativa",
                      "imageUrl": "https://www.bhg.com/thmb/oL0DwR0DXrhFynA2y-oiY-nkCbg=/1878x0/filters:no_upscale():strip_icc()/tango-oakleaf-lettuce-c6f6417e-4cffa63034624d96a9e9ec9a3fe158f9.jpg",
                      "variety": "Romaine",
                      "landType": "Loamy soil",
                      "weatherConditions": "Cool and mild",
                      "distanceBetweenPlants": "8 inches",
                      "idealPlantingDepth": "1/8 inch",
                      "fertilizationAndFumigation": "Fish emulsion and garlic spray",
                       "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 50,
                        "maxHumidity": 85,
                        "pH": 6.5
                    },
                    {
                      "id": 5,
                      "name": "Cucumber",
                      "scientificName": "Cucumis sativus",
                      "imageUrl": "https://www.finedininglovers.com/sites/g/files/xknfdk626/files/2022-06/Type%20of%20cucumber.jpg",
                      "variety": "American Pickling",
                      "landType": "Sandy loam soil",
                      "weatherConditions": "Warm and sunny",
                      "distanceBetweenPlants": "12 inches",
                      "idealPlantingDepth": "1 inch",
                      "fertilizationAndFumigation": "Organic compost and neem oil",
                      "minTemperature": 20,
                        "maxTemperature": 35,
                        "minHumidity": 60,
                        "maxHumidity": 90,
                        "pH": 6.0
                    },
                    {
                      "id": 6,
                      "name": "Pepper",
                      "scientificName": "Capsicum annuum",
                      "imageUrl": "https://hips.hearstapps.com/hmg-prod/images/close-up-of-green-red-and-orange-bell-peppers-royalty-free-image-622418542-1558536290.jpg",
                      "variety": "Bell Pepper",
                      "landType": "Sandy loam soil",
                      "weatherConditions": "Warm and sunny",
                      "distanceBetweenPlants": "18 inches",
                      "idealPlantingDepth": "1/4 inch",
                      "fertilizationAndFumigation": "Compost and natural insect repellents",
                       "minTemperature": 15,
                        "maxTemperature": 30,
                        "minHumidity": 50,
                        "maxHumidity": 85,
                        "pH": 6.0
                    },
                    {
                      "id": 7,
                      "name": "Spinach",
                      "scientificName": "Spinacia oleracea",
                      "imageUrl": "https://www.realsimple.com/thmb/SM_Az3lxe-GGjpMXj5duFoOWyno=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/health-benefits-of-spinach-GettyImages-1188680084-93242645c1c24a08b52a056ea09c3d61.jpg",
                      "variety": "Bloomsdale",
                      "landType": "Sandy soil",
                      "weatherConditions": "Cool temperatures",
                      "distanceBetweenPlants": "6 inches",
                      "idealPlantingDepth": "1/2 inch",
                      "fertilizationAndFumigation": "Aged compost and diatomaceous earth",
                      "minTemperature": 5,
                        "maxTemperature": 20,
                        "minHumidity": 40,
                        "maxHumidity": 70,
                        "pH": 6.5
                    },
                    {
                      "id": 8,
                      "name": "Zucchini",
                      "scientificName": "Cucurbita pepo",
                      "imageUrl": "https://www.lanacion.com.py/resizer/6pKtpv4jEMgF6BcorFyMc3ieTVI=/1016x0/smart/filters:format(jpg):quality(70)/cloudfront-us-east-1.images.arcpublishing.com/lanacionpy/O3CYQSWRJVHQJNRLCK4A4VJH2U.jpeg",
                      "variety": "Black Beauty",
                      "landType": "Sandy loam soil",
                      "weatherConditions": "Warm and sunny",
                      "distanceBetweenPlants": "24 inches",
                      "idealPlantingDepth": "1 inch",
                      "fertilizationAndFumigation": "Compost and neem oil",
                       "minTemperature": 20,
                        "maxTemperature": 35,
                        "minHumidity": 60,
                        "maxHumidity": 90,
                        "pH": 6.0
                    },
                    {
                      "id": 9,
                      "name": "Broccoli",
                      "scientificName": "Brassica oleracea var. italica",
                      "imageUrl": "https://domf5oio6qrcr.cloudfront.net/medialibrary/5390/h1218g16207258089583.jpg",
                      "variety": "Calabrese",
                      "landType": "Loamy soil",
                      "weatherConditions": "Cool temperatures",
                      "distanceBetweenPlants": "18 inches",
                      "idealPlantingDepth": "1/2 inch",
                      "fertilizationAndFumigation": "Organic compost and natural insect repellents",
                      "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 6.0
                    },
                    {
                      "id": 10,
                      "name": "Potato",
                      "scientificName": "Solanum tuberosum",
                      "imageUrl": "https://cdn.mos.cms.futurecdn.net/iC7HBvohbJqExqvbKcV3pP.jpg",
                      "variety": "Russet",
                      "landType": "Sandy loam soil",
                      "weatherConditions": "Cool temperatures",
                      "distanceBetweenPlants": "12 inches",
                      "idealPlantingDepth": "3 inches",
                      "fertilizationAndFumigation": "Well-rotted compost and copper sulfate",
                      "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 5.8
                    },
                      {
                        "id": 11,
                        "name": "Quinoa",
                        "scientificName": "Chenopodium quinoa",
                        "imageUrl": "https://www.cuerpomente.com/medio/2019/07/03/como-hacer-quinoa_77171759_1200x630.jpg",
                        "variety": "White Quinoa",
                        "landType": "Well-drained soil",
                        "weatherConditions": "Cool and dry",
                        "distanceBetweenPlants": "10 inches",
                        "idealPlantingDepth": "1/2 inch",
                        "fertilizationAndFumigation": "Compost and organic fertilizers",
                        "minTemperature": 8,
                        "maxTemperature": 25,
                        "minHumidity": 20,
                        "maxHumidity": 60,
                        "pH": 6.0
                      },
                      {
                        "id": 12,
                        "name": "Lucuma",
                        "scientificName": "Pouteria lucuma",
                        "imageUrl": "https://peru.info/archivos/publicacion/110-imagen-114414992019.jpg",
                        "variety": "Sweet Lucuma",
                        "landType": "Sandy loam soil",
                        "weatherConditions": "Warm and dry",
                        "distanceBetweenPlants": "36 inches",
                        "idealPlantingDepth": "2 inches",
                        "fertilizationAndFumigation": "Well-rotted manure",
                        "minTemperature": 20,
                        "maxTemperature": 30,
                        "minHumidity": 30,
                        "maxHumidity": 70,
                        "pH": 6.5
                      },
                      {
                        "id": 13,
                        "name": "Pisco Grape",
                        "scientificName": "Vitis vinifera",
                        "imageUrl": "https://vinepair.com/wp-content/uploads/2015/12/pisco-social.jpg",
                        "variety": "Muscat",
                        "landType": "Loamy soil",
                        "weatherConditions": "Warm and sunny",
                        "distanceBetweenPlants": "72 inches",
                        "idealPlantingDepth": "2 inches",
                        "fertilizationAndFumigation": "Organic compost and balanced fertilizers",
                        "minTemperature": 15,
                        "maxTemperature": 35,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 6.0
                      },
                      {
                        "id": 14,
                        "name": "Aji Amarillo",
                        "scientificName": "Capsicum baccatum",
                        "imageUrl": "https://e.rpp-noticias.io/xlarge/2019/10/31/504250_859016.jpg",
                        "variety": "Peruvian Yellow Pepper",
                        "landType": "Sandy loam soil",
                        "weatherConditions": "Warm and sunny",
                        "distanceBetweenPlants": "24 inches",
                        "idealPlantingDepth": "1/2 inch",
                        "fertilizationAndFumigation": "Organic compost and well-rotted manure",
                        "minTemperature": 20,
                        "maxTemperature": 35,
                        "minHumidity": 50,
                        "maxHumidity": 80,
                        "pH": 6.5
                      },
                      {
                        "id": 15,
                        "name": "Maca Root",
                        "scientificName": "Lepidium meyenii",
                        "imageUrl": "https://cdn-prod.medicalnewstoday.com/content/images/articles/322/322511/maca-root.jpg",
                        "variety": "Black Maca",
                        "landType": "Loamy soil",
                        "weatherConditions": "Cool and dry",
                        "distanceBetweenPlants": "18 inches",
                        "idealPlantingDepth": "1 inch",
                        "fertilizationAndFumigation": "Natural organic fertilizers",
                        "minTemperature": 10,
                        "maxTemperature": 25,
                        "minHumidity": 30,
                        "maxHumidity": 70,
                        "pH": 6.0
                      },
                      {
                        "id": 16,
                        "name": "Purple Corn",
                        "scientificName": "Zea mays",
                        "imageUrl": "https://cdn-prod.medicalnewstoday.com/content/images/articles/324/324989/purple-corn.jpg",
                        "variety": "Moro Corn",
                        "landType": "Well-drained soil",
                        "weatherConditions": "Warm and rainy",
                        "distanceBetweenPlants": "12 inches",
                        "idealPlantingDepth": "2 inches",
                        "fertilizationAndFumigation": "Organic compost and fish emulsion",
                        "minTemperature": 18,
                        "maxTemperature": 30,
                        "minHumidity": 60,
                        "maxHumidity": 90,
                        "pH": 5.8
                      },
                      {
                        "id": 17,
                        "name": "Lúcuma",
                        "scientificName": "Pouteria lucuma",
                        "imageUrl": "https://www.aldia.unah.edu.pe/wp-content/uploads/2021/12/lucuma-1.jpg",
                        "variety": "Lúcuma de la Costa",
                        "landType": "Sandy loam soil",
                        "weatherConditions": "Warm and dry",
                        "distanceBetweenPlants": "36 inches",
                        "idealPlantingDepth": "2 inches",
                        "fertilizationAndFumigation": "Well-rotted manure",
                        "minTemperature": 20,
                        "maxTemperature": 30,
                        "minHumidity": 30,
                        "maxHumidity": 70,
                        "pH": 6.5
                      },
                      {
                        "id": 18,
                        "name": "Sacha Inchi",
                        "scientificName": "Plukenetia volubilis",
                        "imageUrl": "https://www.rcrperu.com/wp-content/uploads/2019/05/sacha-inchi-en-granos-listo-para-venta-eduarodrigz-gml-com-D_NQ_NP_730076-MPE27139188735_042018-F_1024x1024.jpg",
                        "variety": "Mountain Sacha Inchi",
                        "landType": "Well-drained soil",
                        "weatherConditions": "Cool and humid",
                        "distanceBetweenPlants": "24 inches",
                        "idealPlantingDepth": "1 inch",
                        "fertilizationAndFumigation": "Organic compost and aged manure",
                        "minTemperature": 15,
                        "maxTemperature": 25,
                        "minHumidity": 50,
                        "maxHumidity": 80,
                        "pH": 6.0
                      },
                      {
                        "id": 19,
                        "name": "Cacao",
                        "scientificName": "Theobroma cacao",
                        "imageUrl": "https://www.faborit.com/wp-content/uploads/2020/07/blog-cacao-chocolate-planta.jpg",
                        "variety": "Criollo Cacao",
                        "landType": "Loamy soil",
                        "weatherConditions": "Warm and humid",
                        "distanceBetweenPlants": "48 inches",
                        "idealPlantingDepth": "3 inches",
                        "fertilizationAndFumigation": "Organic compost and cocoa husk mulch",
                        "minTemperature": 20,
                        "maxTemperature": 32,
                        "minHumidity": 60,
                        "maxHumidity": 90,
                        "pH": 6.5
                      },
                      {
                        "id": 20,
                        "name": "Maracuyá",
                        "scientificName": "Passiflora ligularis",
                        "imageUrl": "https://cdn.portalfruticola.com/2020/12/Passion-fruit-shutterstock_120206872-1024x683.jpg",
                        "variety": "Sweet Maracuyá",
                        "landType": "Well-drained soil",
                        "weatherConditions": "Warm and sunny",
                        "distanceBetweenPlants": "24 inches",
                        "idealPlantingDepth": "1 inch",
                        "fertilizationAndFumigation": "Organic compost and balanced fertilizers",
                        "minTemperature": 22,
                        "maxTemperature": 30,
                        "minHumidity": 50,
                        "maxHumidity": 80,
                        "pH": 6.5
                      },
                      {
                            "id": 21,
                            "name": "Yuca",
                            "scientificName": "Manihot esculenta",
                            "imageUrl": "https://imag.bonviveur.com/varios-ejemplares-de-yuca-o-mandioca-enteros-y-sin-pelar.jpg",
                            "variety": "Common Cassava",
                            "landType": "Well-drained soil",
                            "weatherConditions": "Warm and tropical",
                            "distanceBetweenPlants": "36 inches",
                            "idealPlantingDepth": "2 inches",
                            "fertilizationAndFumigation": "Balanced fertilizer and organic compost",
                            "minTemperature": 25,
                            "maxTemperature": 35,
                            "minHumidity": 50,
                            "maxHumidity": 80,
                            "pH": 5.5
                          },
                      {
                        "id": 22,
                        "name": "Yacón",
                        "scientificName": "Smallanthus sonchifolius",
                        "imageUrl": "https://images.squarespace-cdn.com/content/v1/5dc30cbda2d4e36f73f0e4f0/1612530436143-ODAE3LHLHWXQB0DYPR9T/yacon1.jpg",
                        "variety": "Peruvian Yacón",
                        "landType": "Loamy soil",
                        "weatherConditions": "Cool and moist",
                        "distanceBetweenPlants": "18 inches",
                        "idealPlantingDepth": "2 inches",
                        "fertilizationAndFumigation": "Organic compost and aged manure",
                        "minTemperature": 15,
                        "maxTemperature": 25,
                        "minHumidity": 40,
                        "maxHumidity": 80,
                        "pH": 6.0
                      }
                    ]
                  }
                """;

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            JsonNode plantsNode = jsonNode.get("plants");

            if (plantsNode != null && plantsNode.isArray()) {
                // Verificar si la tabla 'plants' está vacía
                if (plantRepository.count() == 0) {
                    // Convertir y guardar los nuevos datos solo si la tabla está vacía
                    List<Plant> plants = objectMapper.convertValue(plantsNode, new TypeReference<List<Plant>>() {});
                    plantRepository.saveAll(plants);
                    return "Seeds generated successfully!";
                } else {
                    return "Table 'plants' is not empty. No seeds inserted.";
                }
            }

            return "Invalid JSON structure";
        } catch (IOException e) {
            // Manejar la excepción
            return "Error generating seeds";
        }
    }

    @Override
    public Long handle(CreatePlantCommand createPlantCommand) {
        Plant plant=Plant.builder().name(createPlantCommand.name())
                .scientificName(createPlantCommand.scientificName())
                .imageUrl(createPlantCommand.imageUrl())
                .variety(createPlantCommand.variety())
                .landType(createPlantCommand.landType())
                .weatherConditions(createPlantCommand.weatherConditions())
                .distanceBetweenPlants(createPlantCommand.distanceBetWeenPlants())
                .idealPlantingDepth(createPlantCommand.idealPlantingDepth())
                .fertilizationAndFumigation(createPlantCommand.fertilizationAndFumigation())
                .pH(createPlantCommand.pH())
                .minHumidity(createPlantCommand.minHumidity())
                .maxHumidity(createPlantCommand.maxHumidity())
                .maxTemperature(createPlantCommand.maxTemperature())
                .minTemperature(createPlantCommand.minTemperature())
                .build();
        plantRepository.save(plant);
        return 1L;
    }

    @Override
    public Long handle(DeletePlantCommand deletePlantCommand) {
        Optional<Plant> plant=plantRepository.findById(deletePlantCommand.id());
        if(plant.isPresent()){
            plantRepository.delete(plant.get());
            return 1L;
        }
        else{
            return 0L;
        }
    }
}
