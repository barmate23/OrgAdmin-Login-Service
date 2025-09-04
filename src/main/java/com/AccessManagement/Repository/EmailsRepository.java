package com.AccessManagement.Repository;


import com.AccessManagement.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailsRepository extends JpaRepository<Email,Integer> {
}
