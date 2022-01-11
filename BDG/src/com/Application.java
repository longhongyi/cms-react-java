package com;

//import com.moudle.data.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import com.alibaba.fastjson.*;
//自己定义的类
//import com.moudle.data.Staff;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String args[]){
//        MySQL mysqlDB=new MySQL();
//        Map affInfo=mysqlDB.getAffInfo(3064);
//        System.out.println();
//        Redis redis=new Redis();
        ConfigurableApplicationContext context=SpringApplication.run(Application.class,args);
//        Staff staff=(Staff)context.getBean("staff");
//        staff.setName("龙宏义");
//        System.out.println(staff);
    }
}
