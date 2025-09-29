package com.example.cardatabase4.web;


import com.example.cardatabase4.domain.Owner;
import com.example.cardatabase4.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }



    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    // 2. 차량 한 대 추가(POST /api/cars)
    @PostMapping("/owners")
    public ResponseEntity<Owner> addCar(@RequestBody Owner owner) {
        Owner savedOwner = ownerService.addOwner(owner);

        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }
    // 3. 차량 한대 조회
    @GetMapping("/cars/{id}")
    public ResponseEntity<Owner> getCarById(@PathVariable Long id) {
        return ownerService.getCarById(id)
                .map(car->ResponseEntity.ok().body(car)) // 차량 정보가 있으면 200OK를 반환할 것
                .orElse(ResponseEntity.notFound().build()); // 없으면 404 Not Found를 return 시킬것
    }
    // 4. 차량 한대 삭제
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        if(ownerService.deleteCar(id)) {
            return ResponseEntity.noContent().build(); // 삭제 성공시 204 No Content return
        } else {
            return ResponseEntity.notFound().build();   // 대상이 없으면 404 Not Found
        }

    }

    // 5. 차량 한대 수정
    @PutMapping("/cars/{id}")
    public ResponseEntity<Owner> updateCar (@PathVariable Long id, @RequestBody Owner carDetails) {
        return ownerService.updateCar(id, carDetails)
                .map(updateCar -> ResponseEntity.ok().body(updateCar)) // 수정 성공 시에는 200 OK
                .orElse(ResponseEntity.notFound().build()); // 없으면 404 Not Found
    }
}
