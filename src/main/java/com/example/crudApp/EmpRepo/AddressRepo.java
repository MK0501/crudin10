package com.example.crudin10.EmpRepo;

import com.example.crudin10.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
