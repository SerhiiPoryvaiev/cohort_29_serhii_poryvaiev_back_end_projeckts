package spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;
    private String name;

    public City(String name) {
        this.name = name;
    }
}
