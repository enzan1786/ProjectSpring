package com.green.jdevd010.CoffeeMintClient.daos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.green.jdevd010.CoffeeMintClient.models.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
