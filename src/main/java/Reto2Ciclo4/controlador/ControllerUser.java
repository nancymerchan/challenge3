/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Ciclo4.controlador;

import Reto2Ciclo4.modelo.User;
import Reto2Ciclo4.servicio.ServiceUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WINDOWS
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class ControllerUser {
    
/**
 * Variable que representa el servicio de Usuario
 */

     @Autowired
    private ServiceUser userService;
    
/**
 * obtener informacion de los usuarios
     * @return 
 */

     @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
/**
 * crear informacion de usuarios 
     * @param user
     * @return 
 */

      @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
/**
 * actualisa los usuarios
     * @param user
     * @return 
 */

    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
/**
 * borra la informacion por id
     * @param id
     * @return 
 */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
/**
 * obtiene informacion del email y contraseña
     * @param email
     * @param password
     * @return 
 */

    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
/**
 * obtiene informacion del imail exixteste
     * @param email
     * @return 
 */

      @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
