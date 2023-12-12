package tn.esprit.springproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Malek Labidi")
                        .email("labidi.malek@esprit.tn")
                .url("https://www.linkedin.com/in/malek-labidi/");
        return contact;
    }

    @Bean
    public GroupedOpenApi blocPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Bloc Management API")
                                .pathsToMatch("/api/blocs/**")
                                .pathsToExclude("**")
                                .build();

    }

    @Bean
    public GroupedOpenApi chambrePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Chambre Management API")
                .pathsToMatch("/api/chambres/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Etudiant Management API")
                .pathsToMatch("/api/etudiants/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi foyerPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Foyer Management API")
                .pathsToMatch("/api/foyers/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi reservationPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Reservation Management API")
                .pathsToMatch("/api/reservations/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi unniversitePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Universite Management API")
                .pathsToMatch("/api/universites/**")
                .pathsToExclude("**")
                .build();

    }
}
