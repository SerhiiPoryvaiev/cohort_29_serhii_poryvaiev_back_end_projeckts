package spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Event(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
