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

            //엔티티를 생성한 상태(비영속)
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

//            System.out.println("=== BEFORE ===");
            //엔티티를 영속
            //1차 캐시에 저장됨
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            //1차 캐시에서 조회
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //영속성에서 제외시킨다(준영속)
//            em.detach(member);
            //영속삭제
//            em.remove(member);


            //1차캐시
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L); //1차캐시에서 가져온다
//
//            System.out.println("result = " + (findMember1 == findMember2));



            //persist의 흐름 이해
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=============================");


//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            em.persist(member); //할 필요없다 자바 컬렉션과 같다


            //flush insert문이 호출된다.
            Member member = new Member(200L, "member200");
            em.persist(member);
            em.flush();

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
