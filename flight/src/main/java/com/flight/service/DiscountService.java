package com.flight.service;

import java.util.List;

import com.flight.entity.Discount;

public interface DiscountService {

	public Discount addDiscount(Discount discount);

	public Discount deleteDiscount(Integer discountId);

	public List<Discount> getAllDiscount();

}