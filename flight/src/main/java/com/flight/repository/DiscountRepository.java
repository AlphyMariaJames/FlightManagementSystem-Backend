package com.flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Discount;

@Repository

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

	@Query("SELECT t FROM Discount t WHERE t.discountCode = ?1")

	Optional<Discount> findByDiscountCode(String discountCode);

}