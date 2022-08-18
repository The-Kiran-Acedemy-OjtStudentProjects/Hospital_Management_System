package com.hospitalmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hospitalmanagement.model.Receptionist;

@Repository("receptionistDao")
public interface ReceptionistDao extends JpaRepository<Receptionist, Integer> {
	Receptionist findByUsernameAndPassword(String username , String password);
	@Query(value = "SELECT count(r) FROM Receptionist r")
    public Long getTotalCount();
	List<Receptionist> findByFirstnameContainingIgnoreCase(String receptionistName);
	Long countByRegisterdate(String registeredDate);
}
