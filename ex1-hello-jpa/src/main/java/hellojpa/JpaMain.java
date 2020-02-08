package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //flush insert문이 호출된다.료
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //특정 엔티티만 준영속 상태로 전환
//            em.detach(member);료

            //영속성 컨텍스트를 완전히 초기화
            em.clear();
            Member member2 = em.find(Member.class, 150L);

            //영속성 컨텍스트를 종
//            em.close();

            System.out.println("=============================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
