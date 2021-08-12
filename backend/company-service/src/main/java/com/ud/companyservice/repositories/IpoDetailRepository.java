package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.IpoDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IpoDetailRepository extends JpaRepository<IpoDetail, Long> {
    public IpoDetail findIpoDetailByCompany_Id(Long companyId);
    public List<IpoDetail> findAllByOrderByOpenDateTimeAsc();
}
