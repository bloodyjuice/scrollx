package devyatovski.yar.scrollx2.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "commentary")
@Getter
@Setter
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    private User commentator;


}
