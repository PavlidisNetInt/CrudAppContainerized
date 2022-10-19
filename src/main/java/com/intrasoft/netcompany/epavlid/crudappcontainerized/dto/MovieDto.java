package com.intrasoft.netcompany.epavlid.crudappcontainerized.dto;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity @Table(name = "movie_tbl")
public class MovieDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "release year", nullable = false)
    private Integer releaseYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieDto movieDto = (MovieDto) o;
        return id != null && Objects.equals(id, movieDto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
