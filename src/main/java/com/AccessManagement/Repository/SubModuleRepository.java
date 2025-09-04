package com.AccessManagement.Repository;

import com.AccessManagement.Model.SubModules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubModuleRepository extends JpaRepository<SubModules,Integer> {

    SubModules findByIsDeletedAndId(boolean b, Integer subModulesId);

    List<SubModules> findByIsDeletedAndModuleModuleCode(boolean b, String mcnf);

    List<SubModules> findByIsDeletedAndModuleId(boolean b, Integer moduleId);
}
