package com.smolaardy.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.studentroster.entities.ContactInfo;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {

}