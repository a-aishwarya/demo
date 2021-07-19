package com.aishwarya.increment.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aishwarya.increment.entity.CustomNumber;

@Repository
public interface IncrementRepository extends CrudRepository<CustomNumber, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<CustomNumber> findById(Long id);
	CustomNumber save(CustomNumber n);
	

	@Modifying
	@Query("update CustomNumber n set n.counter_value =:counter_value where n.id =:id")
	void updateCounter(int counter, Long id);
}
