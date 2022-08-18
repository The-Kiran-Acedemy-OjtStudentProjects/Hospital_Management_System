package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospitalmanagement.dao.ReceptionistDao;
import com.hospitalmanagement.model.Receptionist;

@Service("receptionistService")
public class ReceptionistServiceImp implements ReceptionistService {

	@Autowired
	private ReceptionistDao receptionistDao;
	
	@Override
	public Receptionist addReceptionist(Receptionist receptionist) {
		return receptionistDao.save(receptionist);
	}

	@Override
	public void deleteReceptionistById(Integer id) {
		receptionistDao.deleteById(id);
	}

	@Override
	public Receptionist getReceptionistById(Integer id) {
		Optional<Receptionist> optional = receptionistDao.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Receptionist updateReceptionist(Receptionist receptionist) {
		return receptionistDao.save(receptionist);
	}

	@Override
	public Receptionist loginReceptionist(String username, String password) {
		return receptionistDao.findByUsernameAndPassword(username, password);
	}

	@Override
	public Long getReceptionistTotalCount() {
		return receptionistDao.getTotalCount();
	}

	@Override
	public List<Receptionist> getReceptionistsByFirstName(String firstName) {
		return receptionistDao.findByFirstnameContainingIgnoreCase(firstName);
	}

	@Override
	public Long getReceptionistCountByRegisteredDate(String registerDate) {
		return receptionistDao.countByRegisterdate(registerDate);
	}

}
