package com.example.CryptoCezarWeb.controllers.rest;

import com.example.CryptoCezarWeb.models.LayoutEntity;
import com.example.CryptoCezarWeb.services.iServiceCRUD;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LayoutRestController {
    private final iServiceCRUD service;

    @GetMapping("/layouts")
    public ResponseEntity<List<LayoutEntity>>fineAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/layout/{id}")
    public ResponseEntity<LayoutEntity>getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getLayoutEntityById(id), HttpStatus.OK);
    }
    @PostMapping("/layout")
    public ResponseEntity<String>save(@RequestBody LayoutEntity layout){
        service.addLayoutEntity(layout);
        return new ResponseEntity<>("layout save", HttpStatus.OK);
    }
    @PutMapping("/layout/{id}")
    public ResponseEntity<String>update(@RequestBody LayoutEntity layout, @PathVariable Long id){
        service.update(layout, id);
        return new ResponseEntity<>("layout update", HttpStatus.OK);
    }
    @DeleteMapping("/layout/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>("layout delete", HttpStatus.OK);
    }

}
