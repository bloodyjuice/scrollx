package devyatovski.yar.scrollx2.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "msg")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;
}
