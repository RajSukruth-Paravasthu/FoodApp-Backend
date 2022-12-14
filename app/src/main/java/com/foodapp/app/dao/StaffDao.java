package com.foodapp.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.app.dto.BranchManager;
import com.foodapp.app.dto.Staff;
import com.foodapp.app.repository.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	StaffRepository staffRepository;
	
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public Optional<Staff> findStaffById(int id){
		return staffRepository.findById(id);
	}
	
	public List<Staff> findAllStaffs(){
		return staffRepository.findAll();
	}
	
	public Staff updateStaff(Staff staff,int id) {
		Optional<Staff> optional=findStaffById(id);
		Staff staff2=optional.get();
		staff2.setEmail(staff.getEmail());
		staff2.setName(staff.getName());
		staff2.setPassword(staff.getPassword());
		staff2.setPhoneNumber(staff.getPhoneNumber());
		staff2.setRole(staff2.getRole());
		staff2.setFoodOrders(staff2.getFoodOrders());
		staff2.setBranchManager(staff2.getBranchManager());
		staffRepository.save(staff2);
		return staff2;
	}
	
	public Optional<Staff> deleteStaff(int id){
		Optional<Staff> optional=findStaffById(id);
		if(optional.isEmpty()) {
			return null;
		}
		else
		{
			staffRepository.delete(optional.get());
			return optional;
		}
	}
	
	public List<Staff> getStaffByManager(BranchManager manager){
	    return staffRepository.findByBranchManager(manager);
	}
}

