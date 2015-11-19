package hello;

import java.util.List;
import java.util.ArrayList;

public class Elev {
  private String name;
  private int nota;
  private int id;

  public Elev() {}
  

  public Elev(int id,int nota, String name) {
      this.name = name;
      this.id = id;
	  this.nota = nota;
  }

  public setName(string n){
	  this.name = n;
  }
  
  public setID(int id){
	  this.id=id;
  }
  
  public setNota(int nota){
	  this.nota = nota;
  }
    
  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
}
