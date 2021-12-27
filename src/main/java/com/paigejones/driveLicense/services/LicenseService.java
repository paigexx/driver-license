package com.paigejones.driveLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paigejones.driveLicense.models.License;
import com.paigejones.driveLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	public License create(License license) {
		licenseRepository.save(license);
		return license;
	}
	
	public License findLicense(Long id) {
		Optional<License> license = licenseRepository.findById(id);
		if (license.isPresent()) {
			return license.get();
		}
		else {
			return null;
		}
	}
	
	public Long deleteLicense(Long id) {
		 licenseRepository.deleteById(id);
		 return id;
	}

}

