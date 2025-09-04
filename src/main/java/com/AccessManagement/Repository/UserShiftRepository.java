package com.AccessManagement.Repository;


import com.AccessManagement.Model.Shift;
import com.AccessManagement.Model.UserShiftMapper;
import com.AccessManagement.Model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserShiftRepository extends JpaRepository<UserShiftMapper,Integer> {

}
