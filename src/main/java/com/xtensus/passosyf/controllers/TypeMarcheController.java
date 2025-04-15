package com.xtensus.passosyf.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtensus.passosyf.entities.TypeMarche;
import com.xtensus.passosyf.services.TypeMarcheService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "TypeMarche")
public class TypeMarcheController {

	
	 
    private TypeMarcheService typeMarcheService;

    public TypeMarcheController(TypeMarcheService typeMarcheService) {
      this.typeMarcheService = typeMarcheService;
    }
    
    
  
    @GetMapping(path = "getAllTypeMarche")
    public ResponseEntity<Iterable<TypeMarche>> getAllTypeMarche(){	
      Iterable<TypeMarche> typeMarche=typeMarcheService.ListTypeMarche();
      return new ResponseEntity<>(typeMarche,HttpStatus.OK);
    }
    
    @PostMapping(path = "addTypeMarche")
    public ResponseEntity<TypeMarche> save(@RequestBody TypeMarche typeMarche) {		
      TypeMarche resTypeMarche=typeMarcheService.save(typeMarche);
      //TypeMarche TypeMarche=TypeMarcheService.save(TypeMarche);
      return new ResponseEntity<>(resTypeMarche,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "findTypeMarche/{ref}")
    public TypeMarche getTypeMarcheByRef(@PathVariable(name = "ref") Integer ref){
      System.out.println("ref" +ref);
      TypeMarche TypeMarche = typeMarcheService.getTypeMarcheById(ref);
      return TypeMarche; 
    }
    
    
    
    @DeleteMapping(path = "deleteTypeMarche/{id}") 
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {		
      
  
      return typeMarcheService.delete(id);	
    }
  
     @PutMapping("/updateTypeMarche/{id}")
        public ResponseEntity<TypeMarche> updateTypeMarche(@RequestBody TypeMarche typeMarche,@PathVariable(name = "id") Integer id) {
       TypeMarche resTypeMarche = typeMarcheService.update(typeMarche,id);
            return new ResponseEntity<>(resTypeMarche, HttpStatus.OK);
        }
}
