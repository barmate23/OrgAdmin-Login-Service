package com.AccessManagement.Repository;

import com.AccessManagement.Model.ModuleUserLicenceKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLicenseKeyRepository extends JpaRepository<ModuleUserLicenceKey,Integer> {
    ModuleUserLicenceKey findByIsDeletedAndIsUsedAndId(boolean b, boolean b1, Integer userLicenseKeyId);

    List<ModuleUserLicenceKey> findByIsDeletedAndIsUsedAndLicenceLineSubModuleIdAndLicenceLinePartNumberSubModuleMapperLicenseCategoryAndSubOrganizationId(boolean b, boolean b1, Integer subModuleId, int i, Integer subOrgId);

    ModuleUserLicenceKey findByIsDeletedAndId(boolean b, Integer userLicenseKeyId);

    List<ModuleUserLicenceKey> findByIsDeletedAndIdIn(boolean b, List<Integer> additionalDeviceLicense);



    ModuleUserLicenceKey findByIsDeletedAndIdAndSubOrganizationId(boolean b, Integer userLicenseKeyId, Integer subOrgId);
}
