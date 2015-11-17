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
public class PhoneController {
  private List<Phone> phones = new ArrayList<Phone>();

  PhoneController() {
    Phone p1 = new Phone(1, "laptop", 26);
    Phone p2 = new Phone(2, "playstation", 257);
    Phone p3 = new Phone(3, "headphones", 36);

    phones.add(p1);
    phones.add(p2);
    phones.add(p3);
  }

  @RequestMapping(value="/anime", method = RequestMethod.GET)
  public List<Phone> index() {
    return this.phones;
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Phone p : this.phones) {
      if(p.getId() == id) {
        return new ResponseEntity<Phone>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Phone p : this.phones) {
      if(p.getId() == id) {
        this.phones.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime", method = RequestMethod.POST)
  public ResponseEntity create(@RequestParam(value='name') String name, @RequestParam(value="info") String info) {
    Phone newPhone = new Phone(this.phones.size() + 1, name, info);
    phones.add(newPhone);
    return new ResponseEntity<Phone>(newPhone, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id , @RequestParam(value="name") String name, @RequestParam(value="info") String info) {
    for(Phone p : this.phones) {
      if(p.getId() == id) {
        p.setname(name);
        p.setinfo(info);
        return new ResponseEntity<Phone>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
