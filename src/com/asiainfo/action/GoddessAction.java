package com.asiainfo.action;

import com.asiainfo.dao.GoddessDao;
import com.asiainfo.model.Goddess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 欢迎来到女神禁区
 * 以下是本禁区的功能列表
 * 字母[a]:返回主菜单
 * 字母[b]:可以查看禁区女神的基本信息 query()
 * 字母[c]:可以查看禁区女神的基本信息 get()
 * 字母[d]:可以添加心仪禁区女神 add()
 * 字母[e]:可以删除禁区女神信息 del()
 * 字母[f]:可以更新禁区女神基本信息 edit()
 * 字母[h]:可以查询女神基本信息 query(List<Map<String,Object>> params)
 * 字母[exit]: 退出当前系统返回主菜单
 */
public class GoddessAction {

    public void add(Goddess goddess) throws Exception {

        GoddessDao dao = new GoddessDao();
        dao.addGoddess(goddess);


    }

    public void edit(Goddess goddess) throws Exception{

        GoddessDao dao = new GoddessDao();
        dao.updateGoddess(goddess);

    }

    public void del(Integer id) throws Exception {

        GoddessDao dao = new GoddessDao();
        dao.delGoddess(id);

    }

    public List<Goddess> query() throws Exception {

        GoddessDao dao = new GoddessDao();
        return dao.queryGoddess();

    }

    public List<Goddess> query(List<Map<String,Object>> params) throws SQLException {

        GoddessDao dao = new GoddessDao();
        return dao.queryGoddess(params);

    }

    public Goddess get(Integer id) throws SQLException {

        GoddessDao dao = new GoddessDao();
        return dao.getGoddess(id);

    }

}
