package com.example.demo.fund;

import com.example.demo.fund.Fund;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

public interface FundRepository extends CrudRepository<Fund, Long> {
}
