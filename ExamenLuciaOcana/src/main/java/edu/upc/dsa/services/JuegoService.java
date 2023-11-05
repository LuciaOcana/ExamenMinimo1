package edu.upc.dsa.services;

import edu.upc.dsa.models.Game;
import edu.upc.dsa.JuegoManager;
import edu.upc.dsa.JuegoManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Api(value = "/game", description = "Juego Service")
//@Path establece la ruta para el servicio web
@Path("/game")
//Clase de punto de entrada para el servicio web
public class JuegoService {

    //Esto es una variable de lista de canciones
    private JuegoManager tm;

    //Codigo para administrar unas canciones. Se añaden 3 canciones (Del codigo que estemos haciendo)
//--------------------------------------------------------
    public JuegoService() {
       /* this.tm = JuegoManagerImpl.getInstance();
        if (tm.size() == 0) {
            this.tm.addGame("Minecraft", 3);
        }*/
    }

    //---------------------------------------------------------
//Indica que este metodo se ejecutara cuando una solicitud HTTP GET se ejecute.
    @GET
    //Descripcion del proposito del metodo
    @ApiOperation(value = "get all Games", notes = "asdasd")
    //Especifica las respuestas posibles para esta operacion GET, indicando que una respuesta exitosa es X
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class, responseContainer="List"),
    })
    //Establece la ruta relativa al metodo, lo que sigifica que respondera a solicitudes en la ruta base
    @Path("/")
    //Indicara que el metodo produce datos en formato JSON
    @Produces(MediaType.APPLICATION_JSON)
    //MEtodo que se encarga de recuperar todas las pistas y devolverlas en formato JSON como una respuesta HTTP
    public Response getGames() {
        List<Game> games = this.tm.findAllGames();
        GenericEntity<List<Game>> entity = new GenericEntity<List<Game>>(games) {};
        return Response.status(201).entity(entity).build();
    }
    //---------------------------------------------------------
    @GET
    @ApiOperation(value = "get a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Game.class),
            @ApiResponse(code = 404, message = "Game not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //Metodo que se encarga de obtener la cancion que tiene el Id pasado
    public Response getGame(@PathParam("id") String id) {
        int game_id = Integer.parseInt(id);
        Game t = this.tm.getGame(game_id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }
    //---------------------------------------------------------
    @DELETE
    @ApiOperation(value = "delete a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Game not found")
    })
    @Path("/{id}")
    //Metodo que se encarga de eliminar la cancion que tiene el id pasado
    public Response deleteGame(@PathParam("id") String id) {
        int game_id = Integer.parseInt(id);
        Game t = this.tm.getGame(game_id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteGame(game_id);
        return Response.status(201).build();
    }
    //---------------------------------------------------------
    @PUT
    @ApiOperation(value = "update a Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Game not found")
    })
    @Path("/")
    //Metodo que se encarga de actualizar la lista de canciones
    public Response updateGame(Game game) {
        Game t = this.tm.updateGame(game);
        if (t == null) return Response.status(404).build();
        return Response.status(201).build();
    }
    //---------------------------------------------------------
    @POST
    @ApiOperation(value = "create a new Game", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Game.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    //Metodo que se encarga de añadir una nueva cancion a la lista
    public Response newGame(Game game) {
        if (game.GetDescription()==null || game.GetNumLevels()<0)  return Response.status(500).entity(game).build();
        this.tm.addGame(game);
        return Response.status(201).entity(game).build();
    }

}