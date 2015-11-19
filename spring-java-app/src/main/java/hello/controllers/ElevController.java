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
public class ElevController {
  private List<Elev> elevi = new ArrayList<Elev>();

  ElevController() {
    Elev p1 = new Elev(1, 10, "John");
    Elev p2 = new Elev(2, 1, "Paul");
    Elev p3 = new Elev(3, 7, "Paul");

    elevi.add(p1);
    elevi.add(p2);
    elevi.add(p3);
  }

  @RequestMapping(value="/elev", method = RequestMethod.GET)
  public List<Elev> index() {
    return this.elevi;
  }
 
 
 
 
@RequestMapping(value="/elev", method = RequestMethod.POST)
  public ResponseEntity post() {
    
	  Elev pp = new Elev(10, 8, "Cruela");
	  elevi.add(pp);
    
    return new ResponseEntity <Elev>(pp, new HttpHeaders(), HttpStatus.OK);
  }
	

@RequestMapping(value="/elev/{id}", method = RequestMethod.PUT)
public ResponseEntity put(@PathVariable("id") int id) {
	for(Elev p : this.elevi) {
      if(p.getId() == id) {
		 p.setID(5);
		 p.setName("Viki");
		 p.setNota(2);
		return new ResponseEntity<Elev>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  
  @RequestMapping(value="/elev/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Elev p : this.elevi) {
      if(p.getId() == id) {
        return new ResponseEntity<Elev>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  
  
  
  @RequestMapping(value="/elev/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Elev p : this.elevi) {
      if(p.getId() == id) {
        this.elevi.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
