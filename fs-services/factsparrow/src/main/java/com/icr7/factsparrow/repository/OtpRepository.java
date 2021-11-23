package com.icr7.factsparrow.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icr7.factsparrow.model.FsOtp;

public interface OtpRepository extends JpaRepository<FsOtp, Integer>{
	@Transactional
	@Modifying
	@Query(value="delete from FsOtp otp where otp.email=:email")
	public void deleteByEmail(@Param("email") String email);
	public List<FsOtp> findByEmail(String email);
}
