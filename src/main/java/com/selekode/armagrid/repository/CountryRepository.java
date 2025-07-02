package com.selekode.armagrid.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.selekode.armagrid.database.DatabaseConnection;
import com.selekode.armagrid.database.DatabaseConstants;
import com.selekode.armagrid.model.Country;
import com.selekode.armagrid.model.CountryStats;

public class CountryRepository {
	public static String DB_URL = DatabaseConstants.DB_URL;

	public static List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<>();

		String sql = "SELECT id, short_name, name FROM countries ORDER BY name ASC";

		try (Connection conn = DatabaseConnection.connect();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String shortName = rs.getString("short_name");
				String name = rs.getString("name");

				countries.add(new Country(id, shortName, name));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countries;
	}

	public static List<CountryStats> getCountryStats(int countryId) {
	    List<CountryStats> stats = new ArrayList<>();

	    String sql = "SELECT country_id, section, stat_name, stat_value FROM country_stats WHERE country_id = ?";

	    try (Connection conn = DatabaseConnection.connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, countryId);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("country_id");
	            String section = rs.getString("section");
	            String statName = rs.getString("stat_name");
	            String statValue = rs.getString("stat_value");

	            CountryStats stat = new CountryStats(id, section, statName, statValue);
	            stats.add(stat);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // You can replace this with proper logging
	    }

	    return stats;
	}

	public static Country getCountry(int countryId) {
		Country country = null;
        String sql = "SELECT id, name, short_name FROM countries WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, countryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    country = new Country(0, "", "");
                    country.setId(rs.getInt("id"));
                    country.setName(rs.getString("name"));
                    country.setShortName(rs.getString("short_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
	}
}
