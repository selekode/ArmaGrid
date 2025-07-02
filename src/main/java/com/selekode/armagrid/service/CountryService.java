package com.selekode.armagrid.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.selekode.armagrid.database.DatabaseConnection;
import com.selekode.armagrid.model.Country;
import com.selekode.armagrid.model.CountryStats;
import com.selekode.armagrid.repository.CountryRepository;

@Service
public class CountryService {

    public static List<Country> getAllCountries() {
        List<Country> allCountries = CountryRepository.getAllCountries();
        
        return allCountries;
    }

    public static List<CountryStats> getCountryStats(int countryId) {
    	List<CountryStats> countryStats = CountryRepository.getCountryStats(countryId);
    	return countryStats;
    }
    
    public static Country getCountry(int id) {
		Country country = CountryRepository.getCountry(id);
		System.out.println(country.toString());
		return country;
	}
}
