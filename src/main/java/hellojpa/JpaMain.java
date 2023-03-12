package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // persistence.xml 파일의 persistence-unit 이름을 괄호 안에 적는다
        // 애플리케이션 로딩 시점에 딱 1개만
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 고객이 어떤 행위를 할 때마다 (DB 커넥션 얻어서 쿼리를 날리고 종료할 때마다) 무조건 생
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // db 트랜잭션 실행 (모든 데이터 변경은 트랜잭션 안에서 실행)

        // code
        try {
            // 생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(findMember);

//            // 찾기
//            Member findMember = em.find(Member.class, 1L);
//
//            // JPQL
//            // JPA 가 Member 객체를 대상으로 쿼리를 짠 것이다
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
//
//            // 수정 (트랜잭션 커밋 시점에 알아채고 업데이트)
//            findMember.setName("HelloJPA");

            // 영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("========");

            // 플러시
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            // 쓰기 지연 SQL 저장소에 쌓인 애들이 DB에 반영됨 = 영속성 컨텍스트의 변경 내용을 DB에 동기화
//            em.flush();
//
//            System.out.println("-----------");

            Member member = em.find(Member.class, 150L);
            member.setName("zzzzz");

            // 준영속
//            em.detach(member);
            em.clear();

            // 지웠으니까 다시 조회해온 거임
            Member member2 = em.find(Member.class, 150L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
