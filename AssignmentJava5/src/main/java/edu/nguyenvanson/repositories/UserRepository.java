package edu.nguyenvanson.repositories;

import org.springframework.stereotype.Repository;
import edu.nguyenvanson.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
}
