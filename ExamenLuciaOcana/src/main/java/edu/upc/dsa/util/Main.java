package edu.upc.dsa.util;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final String BASE_URI = "http://localhost:8080/dsaApp/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        //Instancia que se configura para escanear el paquete "edu.upc.dsa.services" en busca de recursos JAX-RS.
        //En la 'direccion' asignada (edu.upc.dsa.services) tenemos que tener los servicios que queremos.
        final ResourceConfig rc = new ResourceConfig().packages("edu.upc.dsa.services");

        //Esto creo que se tiene que poner siempre es para el swagger
        rc.register(io.swagger.jaxrs.listing.ApiListingResource.class);
        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        //Se configuran los detalles de documentacion de la API; titulo, descripcion, version...
        BeanConfig beanConfig = new BeanConfig();

        //Documentación de la web, si la cambio, la info de la web cambiara
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/dsaApp");
        beanConfig.setContact("support@example.com");
        beanConfig.setDescription("REST API for Tracks Manager");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        beanConfig.setResourcePackage("edu.upc.dsa.services");
        beanConfig.setTermsOfServiceUrl("http://www.example.com/resources/eula");
        beanConfig.setTitle("REST API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setScan(true);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        //se crea y se inicia una instancia de Grizzly HTTP Server que escuchará en la direccion definida en este caso en "BASE_URI"
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }



    public static void main(String[] args) {

    }
}