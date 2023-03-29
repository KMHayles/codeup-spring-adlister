package com.codeup.codeupSpringAdlister.repository;

import com.codeup.codeupSpringAdlister.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findById(long id);

}
