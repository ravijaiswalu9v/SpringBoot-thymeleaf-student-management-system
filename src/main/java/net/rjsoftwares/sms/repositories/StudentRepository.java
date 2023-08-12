package net.rjsoftwares.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.rjsoftwares.sms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
