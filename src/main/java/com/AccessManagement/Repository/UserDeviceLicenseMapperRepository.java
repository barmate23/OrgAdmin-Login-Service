package com.AccessManagement.Repository;

import com.AccessManagement.Model.ModuleUserLicenceKey;
import com.AccessManagement.Model.UserDeviceLicenseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDeviceLicenseMapperRepository extends JpaRepository<UserDeviceLicenseMapper,Integer> {
    List<UserDeviceLicenseMapper> findByUserId(Integer userId);

    void deleteAllByIdIn(List<Integer> additionalDeviceLicense);

    List<ModuleUserLicenceKey> findByIsDeletedAndIdIn(boolean b, List<Integer> additionalDeviceLicense);

    List<UserDeviceLicenseMapper> findByIsDeletedAndUserId(boolean b, Integer userId);

    Optional<UserDeviceLicenseMapper> findByIsDeletedAndId(boolean b,Integer id);
}
