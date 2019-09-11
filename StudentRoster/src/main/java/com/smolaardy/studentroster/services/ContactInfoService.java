package com.smolaardy.studentroster.services;

import org.springframework.stereotype.Service;

import com.smolaardy.studentroster.entities.ContactInfo;
import com.smolaardy.studentroster.repositories.ContactInfoRepository;

@Service
public class ContactInfoService {
	
	private final ContactInfoRepository contactInfoRepository;

	public ContactInfoService(ContactInfoRepository contactInfoRepository) {
		this.contactInfoRepository = contactInfoRepository;
	}
	
	public void saveContactInfo(ContactInfo contactInfo) {
		contactInfoRepository.save(contactInfo);
	}
	
}