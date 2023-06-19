package com.wcs.cpfinal.advice;

import com.wcs.cpfinal.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    @Query("SELECT a FROM Advice a WHERE a.user.id = ?1")
    List<Advice> findByUser(Long id);

    List<Advice> findAllByOrderByIdDesc();
}
