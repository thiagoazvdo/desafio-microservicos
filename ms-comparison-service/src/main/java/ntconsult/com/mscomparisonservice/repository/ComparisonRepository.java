package ntconsult.com.mscomparisonservice.repository;

import ntconsult.com.mscomparisonservice.model.Comparison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComparisonRepository extends JpaRepository<Comparison, Integer> {
}
