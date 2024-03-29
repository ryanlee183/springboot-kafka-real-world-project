package com.example.springboot.repository;

import com.example.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
