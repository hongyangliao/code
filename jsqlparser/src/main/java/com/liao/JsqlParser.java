package com.liao;

import com.alibaba.druid.sql.SQLUtils;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.Hashtable;


/**
 * @author hongyangliao
 * @ClassName:
 * @Date 17-12-13 上午11:13
 */
public class JsqlParser {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "select * from user group by user_id having user_id = '123'order by id desc";

        String whereSql = SQLUtils.addCondition(sql, "uesr_id in (1,2,3,6) or 1=1", "mysql");

        System.out.println(whereSql);

//        Hashtable hashtable = new Hashtable();
//        hashtable.put(null,123);
//        int[] array = new int[1];



    }
}
