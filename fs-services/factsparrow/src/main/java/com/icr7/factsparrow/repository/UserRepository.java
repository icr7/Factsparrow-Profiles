package com.icr7.factsparrow.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icr7.factsparrow.model.FsUser;

public interface UserRepository extends JpaRepository<FsUser, Long> {

	public List<FsUser> findIdByEmail(String email);

	@Transactional
	@Modifying
	@Query("update FsUser fs set fs.profilePic=:picName WHERE fs.email=:picEmail")
	public void SaveProfilePicByEmail(@Param("picName") String picName, @Param("picEmail") String picEmail);
}
