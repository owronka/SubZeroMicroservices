@RestController
public class RestController{



@RequestMapping("/registrierung")
public Registrierung registrierung(@RequestBody String name);

} 