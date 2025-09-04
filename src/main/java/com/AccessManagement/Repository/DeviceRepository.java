package com.AccessManagement.Repository;

import com.AccessManagement.Model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {
    List<Device> findByIsDeletedAndIdIn(boolean b, List<Integer> additionalDeviceLicense);

    List<Device> findByIsDeleted(boolean b);
}
