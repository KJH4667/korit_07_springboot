package com.example.cardatabase4.service;


import com.example.cardatabase4.domain.Owner;
import com.example.cardatabase4.domain.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;


    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    // 모든 Owner 목록을 조회한다고 가정하겠습니다.
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    // 새로운 자동차 저장
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }


    public Optional<Owner> getCarById(Long id) {
        return ownerRepository.findById(id);
    }

    // 4. 차량 한대 삭제
    public boolean deleteCar(Long id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //5. 차량 수정
    @Transactional
    public Optional<Owner> updateCar(Long id, Owner ownerDetails) {
        return ownerRepository.findById(id)
                .map(owner -> {
                    owner.setFirstName(ownerDetails.getFirstName());
                    owner.setLastName(ownerDetails.getLastName());
                    return owner;
                });

    }
}

