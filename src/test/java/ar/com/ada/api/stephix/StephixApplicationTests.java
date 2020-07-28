package ar.com.ada.api.stephix;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus.Series;

import ar.com.ada.api.stephix.entities.*;
import ar.com.ada.api.stephix.services.implementations.UsuarioServer;

@SpringBootTest
class StephixApplicationTests {

    public static List<Pelicula> peliculas;

    public static List<Serie> series;

    public static List<Temporada> temporadas;
 
    public static List<Actor> actores;
    
    public static List<Usuario> usuarios;

    public static List<Episodio> episodios;

    public static List<CuentaUser> cuentaUsers;

    static {
        peliculas = new LinkedList<>();

        temporadas = new LinkedList<>();

        series = new LinkedList<>();

        actores = new LinkedList<>();

        usuarios = new LinkedList<>();

        episodios = new LinkedList<>();

        cuentaUsers = new LinkedList<>();

        // peliculas para Stephix

        Actor actor = new Actor();
        actor.setEdad(20);
        actor.setNombre("Fredrick Lordes");
        actor.setDescripcion("simpatico");
        actores.add(actor);

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre("stand de los besos I");
        pelicula.setGenero("comedia");
        pelicula.setAnio(2020);
        pelicula.setCalificacion(9.0);
        pelicula.setClasificacion("APP");
        pelicula.setActores(actores);
        peliculas.add(pelicula);

        Serie serie = new Serie();
        serie.setActores(actores);
        serie.setAnio(2020);
        serie.setCalificacion(10);
        serie.setCantidadDeTemporadas(3);
        serie.setClasificacion("APP");
        serie.setDescripcion("Muy buena");
        serie.setGenero("Suspenso");
        serie.setNombre("Brujas");

        Episodio episodio = new Episodio();
        episodio.setDescripcion("descripcion");
        episodio.setDuracionEnMinutos(40);
        episodio.setNombre("Una broma se acerca");
        episodio.setNumero(1);
        episodios.add(episodio);

        episodio.setDescripcion("descripcion 2");
        episodio.setDuracionEnMinutos(45);
        episodio.setNombre("Fin de clases, sigue la cuarentena... F ");
        episodio.setNumero(2);
        episodios.add(episodio);

        Temporada temporada = new Temporada();
        temporada.setAnio(2020);
        temporada.setNumero(1);
        temporada.setEpisodios(episodios);
        temporadas.add(temporada);

        temporada.setAnio(2020);
        temporada.setNumero(2);

        episodio.setDescripcion("descripcion3");
        episodio.setDuracionEnMinutos(40);
        episodio.setNombre("Sigue la cuarentena");
        episodio.setNumero(1);
        episodios.add(episodio);

        episodio.setDescripcion("descripcion 4");
        episodio.setDuracionEnMinutos(45);
        episodio.setNombre("Fin año, sigue la cuarentena... F ");
        episodio.setNumero(2);
        episodios.add(episodio);

        temporada.setEpisodios(episodios);
        temporadas.add(temporada);

        temporada.setAnio(2020);
        temporada.setNumero(3);

        episodio.setDescripcion("descripcion5");
        episodio.setDuracionEnMinutos(40);
        episodio.setNombre("Esperansita en cuarentena");
        episodio.setNumero(1);
        episodios.add(episodio);

        episodio.setDescripcion("descripcion 6");
        episodio.setDuracionEnMinutos(45);
        episodio.setNombre("2021 sigue la cuarentena... F ");
        episodio.setNumero(2);
        episodios.add(episodio);

        temporada.setEpisodios(episodios);
        temporadas.add(temporada);
        
        serie.setTemporadas(temporadas);
        series.add(serie);

        List<ObjectId> cuentaId = new LinkedList<>();

        Usuario usuario = new Usuario();
        usuario.setNombre("Stephanie");
        usuario.setPassword("amoelchocolate");
        usuario.setUsername("stephanie.castillo@gmail.com");
        usuario.cargarUsuario(usuario.getUsername(), usuario.getPassword());
        cuentaId.add(usuario.get_id());

        usuario.setNombre("John");
        usuario.setPassword("amoelchocolate2");
        usuario.setUsername("joohn@gmail.com");
        usuario.cargarUsuario(usuario.getUsername(), usuario.getPassword());
        usuarios.add(usuario);
        cuentaId.add(usuario.get_id());

        CuentaUser cuentaUser= new CuentaUser();
        cuentaUser.setUsuarios(cuentaId);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Actor actor = new Actor();

        Pelicula pelicula = new Pelicula();

        Serie serie = new Serie();

        Temporada temporada = new Temporada();

        Episodio episodio = new Episodio();

        Usuario usuario = new Usuario();

        CuentaUser cuenta = new CuentaUser();

        int opcion;

        do {
            System.out.println("Bienvenido cree un usuario");
            usuarios.forEach(StephixApplicationTests::printUsuario);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, usuarios.size()));

        usuario = usuarios.get(opcion - 1);

        System.out.println("Se creo el usuario: " + usuario.getNombre());

        cuenta = cuentaUsers.get(opcion - 1);

        System.out.println("Se creo el usuario: " + cuenta.get_id());

        cuentaUsers.forEach(StephixApplicationTests::printCuentaUser);

        do {
            System.out.println("Seleccione 1 Actor: ");
            actores.forEach(StephixApplicationTests::printActor);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, actores.size()));

        actor = actores.get(opcion - 1);

        System.out.println("peli elegida: " + actor.getNombre());
        
        do {
            System.out.println("Cree un episodio");
            episodios.forEach(StephixApplicationTests::printEpisodio);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, episodios.size()));

        episodio = episodios.get(opcion - 1);

        System.out.println("Se creo el episodio: " + episodio.getNombre());

        do {
            System.out.println("Cree una temporada ");
            temporadas.forEach(StephixApplicationTests::printTemporada);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, temporadas.size()));

        temporada = temporadas.get(opcion - 1);

        System.out.println("peli elegida: " + temporada.getNumero());

        do {
            System.out.println("Seleccione 1 Serie ");
            series.forEach(StephixApplicationTests::printSerie);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, series.size()));

        serie = series.get(opcion - 1);

        System.out.println("peli elegida: " + serie.getNombre());

        do {
            System.out.println("Seleccione 1 para crear una pelicula ");
            peliculas.forEach(StephixApplicationTests::printPeli);
            opcion = scanner.nextInt();
        } while (!isOpcionValida(opcion, peliculas.size()));

        pelicula = peliculas.get(opcion - 1);

        System.out.println("peli elegida: " + pelicula.getNombre());
    }

    private static void printPeli(Pelicula peli) {
        System.out.println(peli.get_id() + ") " + peli.getNombre());
    }

    private static void printEpisodio(Episodio episodio) {
        System.out.println(episodio.get_id() + ") " + episodio.getNombre());
    }

    private static void printTemporada(Temporada temporada) {
        System.out.println(temporada.get_id() + ") " + temporada.getNumero());
    }

    private static void printSerie(Serie serie) {
        System.out.println(serie.get_id() + ") " + serie.getNombre());
    }

    private static void printActor(Actor actor) {
        System.out.println(actor.get_id() + ") " + actor.getNombre());
    }

    private static void printUsuario(Usuario usuario) {
        System.out.println(usuario.get_id() + ") " + usuario.getNombre());
    }

    private static void printCuentaUser(CuentaUser cuentaUser) {
        System.out.println(cuentaUser.get_id());
    }
    private static boolean isOpcionValida(int opc, int max) {
        return opc >= 1 && opc <= max;
    }
}