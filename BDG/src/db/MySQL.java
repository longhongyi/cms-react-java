package db;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQL {
    protected Connection connBase,connTracking;
    protected Statement stBase,stTracking;
    //数据库连接
    public MySQL(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connBase = DriverManager.getConnection("jdbc:mysql://"+Config.MYSQL_HOST+"/"+Config.MYSQL_DB_BASE+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",Config.MYSQL_USER,Config.MYSQL_PASS);
            stBase=connBase.createStatement();

            connTracking=DriverManager.getConnection("jdbc:mysql://"+Config.MYSQL_HOST+"/"+Config.MYSQL_DB_TRACKING+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",Config.MYSQL_USER,Config.MYSQL_PASS);
            stTracking=connTracking.createStatement();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected Map<String,String> resultToMap(ResultSet rs){
        Map<String,String> hm=new HashMap<String,String>();
        try {
            ResultSetMetaData rsmd=rs.getMetaData();
            int count=rsmd.getColumnCount();
            if(rs.next()){
                for(int i=1;i<=count;i++){
                    String key=rsmd.getColumnName(i);
                    String value=rs.getString(i);
                    hm.put(key,value);
                }
                return hm;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Map<String,String> getAffInfo(int affId){
        String sql="SELECT ID,Account,Password from wf_aff where ID = ?";
        try {
            PreparedStatement ps=connBase.prepareStatement(sql);
            ps.setInt(1,affId);
            ResultSet rs=ps.executeQuery();
            return resultToMap(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
