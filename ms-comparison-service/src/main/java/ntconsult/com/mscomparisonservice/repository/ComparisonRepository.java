package ntconsult.com.mscomparisonservice.repository;

import ntconsult.com.mscomparisonservice.model.ComparisonResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparisonRepository extends JpaRepository<ComparisonResult, Long> {
}
