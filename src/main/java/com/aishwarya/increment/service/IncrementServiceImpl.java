package com.aishwarya.increment.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishwarya.increment.entity.CustomNumber;
import com.aishwarya.increment.repository.IncrementRepository;

@Service
public class IncrementServiceImpl implements IncrementService {
	
	Logger logger = LoggerFactory.getLogger(IncrementServiceImpl.class);

	@Autowired
	IncrementRepository incrementRepository;
	

	@Override
	public void incrementCounter(Long id) {
		try {
			
			//Number number =  Optional.empty();
			Optional<CustomNumber> optionalNumber = getOptional();
			
			
			if (optionalNumber.isPresent()) 
			{
				CustomNumber customNumber = optionalNumber.get();
				int updatedCount = customNumber.getCounter() + 1;
				customNumber.setCounter(updatedCount);
				incrementRepository.save(customNumber);
			}
			
		} catch (Exception e) {
			logger.error("Exception occurred while incrementing counter", e);
			throw e;
		}

	}
	
	Optional<CustomNumber> getOptional()
		{
		return Optional.empty();
		}

	@Override
	public void setInitialValue(Long id) {
		try {
			boolean isAlreadyExist = incrementRepository.existsById(id);
			if(!isAlreadyExist) {
				CustomNumber customNumber = new CustomNumber();
				customNumber.setId(id);
				incrementRepository.save(customNumber);
			} else {
				logger.info("Number already exist with the id " + id);
			}
		} catch (Exception e) {
			logger.error("Exception occurred while setting the initial value of number", e);
			throw e;
		}
		
	}

}
