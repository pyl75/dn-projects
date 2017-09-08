package com.dongnao.jack.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.dongnao.jack.bean.ConsultContent;
import com.dongnao.jack.bean.ConsultContract;
import com.dongnao.jack.dao.IConsultContract;

@Service
public class CommonServiceImpl implements CommonService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /*@Autowired
    public IConsultContract iConsultContract;*/
    
    public List<ConsultContent> queryContent(Map map) {
        String sql = "select * from consult_content a where a.state = 0 and a.type = 1 order by a.itemindex";
        return jdbcTemplate.query(sql, new RowMapper<ConsultContent>() {
            
            public ConsultContent mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                ConsultContent cc = new ConsultContent();
                cc.setContent(rs.getString("content"));
                cc.setId(rs.getInt("id"));
                cc.setItemIndex(rs.getInt("itemIndex"));
                cc.setState(rs.getInt("state"));
                cc.setType(rs.getString("type"));
                return cc;
            }
        });
    }
    
    //    public int updateConsultContract(String psptId, int id) {
    //        return iConsultContract.
    //    }
    
   /* public List<ConsultContract> queryConsultContract() {
        return iConsultContract.findAll();
    }*/
    
}
