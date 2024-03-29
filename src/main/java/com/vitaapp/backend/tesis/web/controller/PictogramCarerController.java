package com.vitaapp.backend.tesis.web.controller;

import com.vitaapp.backend.tesis.domain.Pictogram;
import com.vitaapp.backend.tesis.domain.PictogramCarer;
import com.vitaapp.backend.tesis.domain.message.ResponsePersonalized;
import com.vitaapp.backend.tesis.domain.repository.PictogramCarerRepository;
import com.vitaapp.backend.tesis.domain.services.PictogramCarerService;
import com.vitaapp.backend.tesis.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carer/pictogram")
public class PictogramCarerController {
    @Autowired
    private PictogramCarerService pictogramCarer;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/all")
    public List<PictogramCarer> getAll(){
        return pictogramCarer.getAll();
    }

    @GetMapping("/subcategory/{id}")
    public List<PictogramCarer> getAllByIdSubcategory(@PathVariable int id, @RequestHeader(name="Authorization") String token, @RequestParam(required = false) String email){
        token = token.substring(7);
        String emailCarer = jwtUtil.extractUsername(token);
        if(emailCarer.substring(0, 6).equals("older-")) {
            if(email != null) {
                emailCarer = email;
            } else {
                return new ArrayList<>();
            }
        }
        return pictogramCarer.getAllByIdSubcategory(id, emailCarer);
    }
    @PostMapping("/add")
    public ResponseEntity<?> save(@Valid @RequestBody PictogramCarer pictogram){
        return pictogramCarer.save(pictogram);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return pictogramCarer.getById(id);
    }

    @PostMapping("/add/list")
    public ResponseEntity<?> saveList(@Valid @RequestBody List<PictogramCarer> pictograms){
        return pictogramCarer.saveList(pictograms);
    }

    @PutMapping("/update-position")
    public ResponseEntity<?> updatePosition(@Valid @RequestBody List<PictogramCarer> pictograms){
        return pictogramCarer.updatePosition(pictograms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePersonalized> delete(@PathVariable int id){
        return pictogramCarer.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PictogramCarer pictogram){
        return pictogramCarer.update(id, pictogram);
    }

}
