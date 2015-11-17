package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class UserController {
  private List<User> users = new ArrayList<User>();

  UserController() {
    User p1 = new User(1, "laptop", 26);
    User p2 = new User(2, "playstation", 257);
    User p3 = new User(3, "headusers", 36);

    users.add(p1);
    users.add(p2);
    users.add(p3);
  }

  @RequestMapping(value="/anime", method = RequestMethod.GET)
  public List<User> index() {
    return this.users;
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(User p : this.users) {
      if(p.getId() == id) {
        return new ResponseEntity<User>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(User p : this.users) {
      if(p.getId() == id) {
        this.users.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime", method = RequestMethod.POST)
  public ResponseEntity create(@RequestParam(value='last_name') String last_name, @RequestParam(value="first_name") String first_name) {
    User newUser = new User(this.users.size() + 1, last_name, first_name);
    users.add(newUser);
    return new ResponseEntity<User>(newUser, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id , @RequestParam(value="last_name") String last_name, @RequestParam(value="first_name") String first_name) {
    for(User p : this.users) {
      if(p.getId() == id) {
        p.setlast_name(last_name);
        p.setfirst_name(first_name);
        return new ResponseEntity<User>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
