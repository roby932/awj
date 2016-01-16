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
public class AnimeController {
  private List<Anime> animes = new ArrayList<Anime>();

  AnimeController() {
    Anime p1 = new Anime(1, "Shigatsu", 26);
    Anime p2 = new Anime(2, "Bleach", 257);
    Anime p3 = new Anime(3, "Kaminomi", 36);

    animes.add(p1);
    animes.add(p2);
    animes.add(p3);
  }

  @RequestMapping(value="/anime", method = RequestMethod.GET)
  public List<Anime> index() {
    return this.animes;
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Anime p : this.animes) {
      if(p.getId() == id) {
        return new ResponseEntity<Anime>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Anime p : this.animes) {
      if(p.getId() == id) {
        this.animes.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/anime", method = RequestMethod.POST)
  public ResponseEntity create(@RequestParam(value="name") String name, @RequestParam(value="numberOfEp") int numberOfEp) {
    Anime newAnime = new Anime(this.animes.size() + 1, String.format(name), numberOfEp);
    animes.add(newAnime);
    return new ResponseEntity<Anime>(newAnime, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/anime/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id , @RequestParam(value="name") String name, @RequestParam(value="numberOfEp") int numberOfEp) {
    for(Anime p : this.animes) {
      if(p.getId() == id) {
        p.setname(name);
        p.setnumberOfEp(numberOfEp);
        return new ResponseEntity<Anime>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
