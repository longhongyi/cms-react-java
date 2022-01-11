package com.moudle.mapper;

import java.util.List;

import com.moudle.data.Company;


public interface CompanyMapper {
    //查找所有公司信息
    public List<Company> selectAllCompany(Company company);
    //添加一个公司
    public void addCompany(Company company);
}
