package com.AccessManagement.Repository;

import com.AccessManagement.Model.SysConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysConfigurationRepository extends JpaRepository<SysConfiguration,Integer> {
    List<SysConfiguration> findByIsDeleted(boolean b);
}
