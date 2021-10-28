package devyatovski.yar.scrollx2.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public enum ReactionType {
    LIKE,
    SAD,
    GOOD,
    BAD,
    EVIL,
    DISLIKE,
    LOVELY;

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
