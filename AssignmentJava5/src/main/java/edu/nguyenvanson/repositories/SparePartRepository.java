/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nguyenvanson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.nguyenvanson.models.SparePart;

/**
 *
 * @author son so
 */
@Repository
public interface SparePartRepository extends JpaRepository<SparePart, String>{
    
}
