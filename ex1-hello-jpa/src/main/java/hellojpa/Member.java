package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MBR")
public class Member {

    @Id
    private Long id;

    //컬럼 매핑
    @Column
    private String name;

    private Integer age;

    //enum 타입 매핑 타입지정은 필수다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //날짜 타입 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //특정 필드를 컬럼에서 제외
    @Transient
    private int temp;
    //BLOB, CLOB 매핑
    @Lob
    private String description;

    public Member() {
    }
}
