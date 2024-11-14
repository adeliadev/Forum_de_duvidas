package com.forum.orbis.repository;

import com.forum.orbis.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long> {
}
