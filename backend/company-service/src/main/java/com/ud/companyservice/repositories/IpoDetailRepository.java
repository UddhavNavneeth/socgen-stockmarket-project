package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.IpoDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoDetailRepository extends JpaRepository<IpoDetail, Long> {
    public IpoDetail findIpoDetailByCompany_Id(Long companyId);
}
