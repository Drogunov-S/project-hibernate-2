package com.javarush.drogunov.model.entity;

import com.javarush.drogunov.repository.mysql.convertes.RatingAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
@Table(name = "film")
public class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private List<Actor> actors;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    @Convert(converter = RatingAttributeConverter.class)
    private Rating rating;
    //TODO Set
    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
    
    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", categories=" + categories.size() +
                ", actors=" + actors.size() +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", language=" + language +
                ", originalLanguageId=" + originalLanguageId +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating=" + rating +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
