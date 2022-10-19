package com.intrasoft.netcompany.epavlid.crudappcontainerized.repository;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
