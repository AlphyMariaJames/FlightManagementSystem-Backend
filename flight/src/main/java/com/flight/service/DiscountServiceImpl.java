package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.flight.entity.Discount;

import com.flight.exceptions.RecordAlreadyPresentException;

import com.flight.repository.DiscountRepository;

@Service

public class DiscountServiceImpl implements DiscountService {

	@Autowired

	private DiscountRepository discountRepository;

	@Override

	public Discount addDiscount(Discount discount) {

		if (!discountRepository.findByDiscountCode(discount.getDiscountCode()).isPresent())

			return discountRepository.save(discount);

		else {

			throw new RecordAlreadyPresentException(
					"Discount with code: " + discount.getDiscountCode() + " already exists");

		}

	}

	@Override

	public Discount deleteDiscount(Integer discountId) {

		Discount deletedRecord = discountRepository.getById(discountId);

		if (deletedRecord != null) {

			discountRepository.deleteById(discountId);

		}

		return deletedRecord;

	}

	@Override

	public List<Discount> getAllDiscount() {

		// TODO Auto-generated method stub

		return discountRepository.findAll();

	}

}