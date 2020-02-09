package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//@SequenceGenerator(name = "member_seq_generator",
//        sequenceName = "member_seq")
@TableGenerator(
        name = "MEMBER_SQE_GENETOR",
        table = "MY_SEQUENCES",
        pkColumnName = "MEMBER_SEQ",
        allocationSize = 1
)
public class Member {

    @Id
    //@GeneratedValue 자동 증가시켜준다
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "member_seq_generator")
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SQE_GENETOR")
    private Long id;

    @Column
    private String name;

    public Member() {
    }
}
