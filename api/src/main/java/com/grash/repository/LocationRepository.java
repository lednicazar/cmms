package com.grash.repository;

import com.grash.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
    Collection<Location> findByCompany_Id(Long id);

    Page<Location> findByCompany_Id(Long id, Pageable pageable);

    Page<Location> findByParentLocation_Id(Long id, Pageable pageable);

    Optional<Location> findByNameIgnoreCaseAndCompany_Id(String locationName, Long companyId);

    Optional<Location> findByIdAndCompany_Id(Long id, Long companyId);

    int countByParentLocation_Id(Long locationId);
}
