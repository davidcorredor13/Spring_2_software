package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    
    /**
    *se cra la clase test, en la cual se prueban todas las funcionalidades del proyecto
    */
    @Autowired
    private UsuarioRepo usuarioRepo;


    @Autowired
    private PlanRepo productoRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void filtratNombreTest(){
        List<Usuario> listaUsuarios = usuarioRepo.findAllByNombreContains("alba");
        listaUsuarios.forEach( u -> System.out.println(u));
    }

      //metodo para paginar listas
    @Test
    @Sql("classpath:usuarios.sql")
    public void paginarListaTest() {

        Pageable paginador = (Pageable) PageRequest.of(0,2);
        Page<Usuario> lista = usuarioRepo.findAll(paginador);

        System.out.println(lista.stream().collect(Collectors.toList()));

    }
     //metodo para ordenar una lista
    @Test
    @Sql("classpath:usuarios.sql")
    public void ordenarListaTest() {


        List<Usuario> lista= usuarioRepo.findAll(Sort.by("nombre"));
        System.out.println(lista);

    }







    }

/*
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;



    @Test
    public void resgistrarUsuarioTest(){
        //guardar usuario en la base de datos
        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);
           ciudadRepo.
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "17171717");
        telefonos.put("celular", "3138745728");
        Usuario usuario = new Usuario("123","fabian", LocalDate.now(),GeneroPersona.MASCULINO, "fabian@gmail.com",telefonos,ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);


    }

    @Test
    public void eliminarUsuarioTest(){
    //guardar usuario en la base de datos
        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "17171717");
        telefonos.put("celular", "3138745728");
        Usuario usuario = new Usuario("123","fabian", LocalDate.now(),GeneroPersona.MASCULINO, "fabian@gmail.com",telefonos,ciudad);



        usuarioRepo.save(usuario);
        //elimino el usuario
        usuarioRepo.deleteById("123");
        //busco el usuario para comprobar q no exista
        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);

        Assertions.assertNull(usuarioBuscado);

    }

    @Test
    public void actualizarUsuarioTest(){
    //guardar usuario en la base de datos
        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "17171717");
        telefonos.put("celular", "3138745728");
        Usuario usuario = new Usuario("123","fabian", LocalDate.now(),GeneroPersona.MASCULINO, "fabian@gmail.com",telefonos,ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        //modifico el email
        usuarioGuardado.setEmail("mauricio@gmail.com");
        //actualizo el usuario guardandolo nuevamente
        usuarioRepo.save(usuarioGuardado);
        //busco el usuario
        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);
        //comparo q halla tomado la actualizacion
        Assertions.assertEquals("mauricio@gmail.com", usuarioBuscado.getEmail());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void ListarUsuarioTest(){

        List<Usuario> usuarios = usuarioRepo.findAll();

        Assertions.assertEquals(3, usuarios.size());
    usuarios.forEach(u -> System.out.println(u) );
    }

*/

