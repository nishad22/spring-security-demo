package spring.secuirty.spring_security_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.secuirty.spring_security_demo.model.Loans;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long>{

    List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);
}
