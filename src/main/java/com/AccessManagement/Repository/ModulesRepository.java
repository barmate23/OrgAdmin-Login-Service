package com.AccessManagement.Repository;

import com.AccessManagement.Model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModulesRepository extends JpaRepository<Modules,Integer> {
    List<Modules> findByIsDeleted(boolean b);
}
