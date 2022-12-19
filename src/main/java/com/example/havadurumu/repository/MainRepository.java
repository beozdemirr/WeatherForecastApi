package com.example.havadurumu.repository;


import com.example.havadurumu.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<MainEntity, Long> {

}
