package com.sourav.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sourav.addressapp.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "SELECT a.id, a.lane1, a.lane2, a.state, a.zip from address a join employee e on e.id=a.employee_id where a.employee_id=:employeeId")
    Address getAddressByEmployeeId(@Param("employeeId") int employeeId);

}
