package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.Admitapply;
import com.workstudy.ssm.model.Questionary;
import com.workstudy.ssm.model.StudentLib;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.service.AdmitapplyService;
import com.workstudy.ssm.service.QuestionaryService;
import com.workstudy.ssm.service.StudentLibService;
import com.workstudy.ssm.service.UserService;
import com.workstudy.ssm.utils.ExportExcelUtil;
import com.workstudy.ssm.vo.InfoVo;
import com.workstudy.ssm.vo.StudentLibVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/19 0019
 * Time: 13:57
 */
@Controller
public class StudentLibController {
    private String getCurrentYear () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }
    @Resource
    private UserService userService;
    @Resource
    private QuestionaryService questionaryService;
    @Resource
    private AdmitapplyService admitapplyService;
    @Resource
    private StudentLibService studentLibService;


    private StudentLibVo getExportData (String studentId, String tableYear) {
        StudentLibVo studentLibVo = new StudentLibVo();
        User user = userService.getUserInfoById(studentId);
        Questionary questionary = questionaryService.getTable(studentId, tableYear);
        Admitapply admitapply = admitapplyService.getTable(studentId, tableYear);
        StudentLib studentLib = studentLibService.getItem(studentId, tableYear);


        studentLibVo.setAcademy(user.getAcademy());
        studentLibVo.setName(user.getName());
        studentLibVo.setSex(questionary.getSex());
        studentLibVo.setMajorAndClassName(user.getMajor()+user.getClassName());
        studentLibVo.setStudentId(user.getUserId());
        studentLibVo.setIdentityCardId(questionary.getIdentityCardId());
        studentLibVo.setAddress(questionary.getAddress());
        studentLibVo.setIsLoan(studentLib.getIsLoan().toString());
        studentLibVo.setIsWorkAndStudy(studentLib.getIsWorkAndStudy().toString());
        studentLibVo.setAwardsName(studentLib.getAwardsName());
        studentLibVo.setAwardsNumber(studentLib.getAwardsNumber());
        studentLibVo.setHelpsName(studentLib.getHelpsName());
        studentLibVo.setHelpsNumber(studentLib.getHelpsNumber());
        studentLibVo.setFamilySummary(admitapply.getReason());
        studentLibVo.setIsVery(admitapply.getAdminResult() == 3 ? "是" : "否");
        studentLibVo.setPhone(user.getPhone());
        studentLibVo.setOther(studentLib.getOther());

        return studentLibVo;
    }



    @RequestMapping(value = "/studentlibtablesaveExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("通过poi导出studentlib excel文件！");

        //模拟数据库取值
        List<InfoVo> list = new ArrayList<>();
        String year = getCurrentYear();
        String tableYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<StudentLib> studentLibs = studentLibService.getTablesByYear(tableYear);
        for (int i = 0; i < studentLibs.size(); i++) {
            System.out.print(i);
            StudentLib form = studentLibs.get(i);
            if (form.getIsCheckin() == 0) {
                System.out.print("continue");
                continue;
            }
            StudentLibVo vo = getExportData(form.getStudentId(), tableYear);
            vo.setIndex(Integer.toString(i + 1));
            list.add(vo);
        }

        ExportExcelUtil.save(response, StudentLibVo.lastRow, list, "StudentLib.xls", "【励志生库】家庭经济困难学生信息登记表和统计表.xls");
    }
}
