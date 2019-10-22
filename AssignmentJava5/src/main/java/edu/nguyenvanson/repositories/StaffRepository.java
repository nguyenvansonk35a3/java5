package edu.nguyenvanson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.nguyenvanson.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{
    
}
