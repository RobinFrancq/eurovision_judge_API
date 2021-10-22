package com.privateprojects.eurovisionjudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AbstractRepository<ENTITY> extends JpaRepository<ENTITY, Integer> {
}
