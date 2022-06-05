package com.example.demo.repository;

import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.SpecialProductEntity;
import com.example.demo.model.entity.enums.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpecialProductRepository extends JpaRepository<SpecialProductEntity, Long> {
}
