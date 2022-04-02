//package com.controller;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Date;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//import java.text.SimpleDateFormat;
//
//import com.alibaba.fastjson.JSON;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//导入自定义的类
//import com.datasource.entities.Company;
//import com.datasource.mappers.CompanyMapper;

//@RestController
//public class Controller {
//    @RequestMapping("/addCompany")
//    public void addCompany(@RequestBody Map params) throws IOException,Exception {
//
//        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
//        SqlSession ss = ssf.openSession();
//
//        CompanyMapper companyMapper=ss.getMapper(CompanyMapper.class);
//
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        Date createdDate=dateFormat.parse((String)params.get("createdDate"));
//        Company company = new Company();
//        company.setName((String)params.get("name"));
//        company.setCreationDate(createdDate);
//        company.setNumOfMember((int)params.get("memberNum"));
//
//        companyMapper.addCompany(company);
//        ss.commit();
//        // 关闭 SqlSession
//        ss.close();
//    }
//
//    @RequestMapping("/findCompany")
//    public String findCompany(@RequestBody Map params) throws IOException,Exception {
//
//        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
//        SqlSession ss = ssf.openSession();
//
//        CompanyMapper companyMapper=ss.getMapper(CompanyMapper.class);
//
//        Company company = new Company();
//        company.setName((String)params.get("name"));
//        List<Company> companyList=companyMapper.selectAllCompany(company);
//
//        String companyJsonStr = JSON.toJSONString(companyList);
//        return companyJsonStr;
//    }
//}
