package hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private  String city;



    public Event(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Event( String name, String city) {

        this.name = name;
        this.city = city;
    }


}
