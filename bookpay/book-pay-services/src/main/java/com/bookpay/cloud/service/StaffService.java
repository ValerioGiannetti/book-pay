package com.bookpay.cloud.service;

import com.bookpay.cloud.dto.StaffDto;

public interface StaffService {

	public void saveStaff(StaffDto staffDto);

	public void deleteStaff(String idStaff);

	public void updateStaff(StaffDto dto);

}
