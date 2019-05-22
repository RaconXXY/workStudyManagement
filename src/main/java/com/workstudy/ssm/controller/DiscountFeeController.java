package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.*;
import com.workstudy.ssm.service.*;
import com.workstudy.ssm.utils.ExportExcelUtil;
import com.workstudy.ssm.utils.ResponseData;
import com.workstudy.ssm.utils.WordGenerator;
import com.workstudy.ssm.vo.DiscountFeeVo;
import com.workstudy.ssm.vo.InfoVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alander on 2017/8/2.
 */
//学费减免申请表
@Controller
public class DiscountFeeController {
    private Logger log = Logger.getLogger(EncouragementController.class);
    @Resource
    private DiscountFeeService discountFeeService;
    @Resource
    private HelpService helpService;
    @Resource
    private AwardService awardService;
    @Resource
    private UserService userService;
    @Resource
    private AdmitapplyService admitapplyService;



    private String getCurrentYear () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }


    @PostMapping("/discountfeetable")
    @ResponseBody
    public Map discountfeetable(@RequestBody DiscountFee table) {
        List<Award> awards = table.getAwards();
        List<Help> helps = table.getHelps();
        awardService.deleteAwardByStId(table.getStudentId());
        for (Award award : awards) {
            if (null != award) {
                String mMessage = awardService.createTable(award);
                log.info("member : " + mMessage);
            } else {
                log.info("空对象");
            }
        }

            helpService.deleteHelpByStId(table.getStudentId());
        for (Help help : helps) {
            if (null != help) {
                String hMessage = helpService.createTable(help);
                log.info("member : " + hMessage);
            } else {
                log.info("空对象");
            }
        }


        String message = discountFeeService.createTable(table);
        ResponseData resdata = ResponseData.ok();
        if (!message.equals("申请表登记成功！")) {
            resdata = ResponseData.customerError();
        }
        resdata.putDataValue("result", message);
        return resdata.toMap();
    }

    @PostMapping("/discountfeetablesave")
    public void save(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Map<String, Object> map = new HashMap<>();

        Enumeration<String> paramNames = req.getParameterNames();
        // 通过循环将表单参数放入键值对映射中
        while (paramNames.hasMoreElements()) {
            String key = paramNames.nextElement();
            String value = req.getParameter(key);
            map.put(key, value);
        }
        // 发现每个字段的值末尾莫名其妙多了/所以去掉它
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
////            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            String str = entry.getValue().toString();
//            entry.setValue(str.substring(0, str.length() - 1));
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
        // TODO 检查字段完整性
        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        // 否则Freemarker的模板在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了

//        WordGenerator.save(res, map, "DiscountFee", "DiscountFee");
        log.info(map);
        WordGenerator.save(res, map, "DiscountFee", "杭州师范大学学费减免申请审批表");

    }

    @RequestMapping(value = "/discountfeetablesaveExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("通过poi导出discountfee excel文件！");

        //模拟数据库取值
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<DiscountFee> discountFees = discountFeeService.getTablesByYear(createdYear);
        List<InfoVo> list = new ArrayList<>();



        for (int i = 0; i < discountFees.size(); i++) {
            DiscountFeeVo vo = new DiscountFeeVo();
            DiscountFee form = discountFees.get(i);
            if (form.getAdminResult() == -1) {
                continue;
            }
            String stId = form.getStudentId();
            User user = userService.getUserInfoById(stId);
            Admitapply admitapply = admitapplyService.getTable(stId, createdYear);
            List<Award> awards = awardService.getAwardsByStId(stId);
            List<Help> helps = helpService.getHelpsByStId(stId);
            Integer awardNum = 0;
            Integer helpNum = 0;
            for (Award award : awards) {
                awardNum += award.getAwardNumber();
            }
            for (Help help : helps) {
                helpNum += help.getHelpNumber();
            }
            vo.setIndex(Integer.toString(i + 1));
            vo.setName(user.getName());
            vo.setAcademy(user.getAcademy());
            vo.setClassName(user.getMajor()+user.getClassName());
            vo.setStudentId(user.getUserId());
            vo.setSex(form.getSex());
            vo.setIsLoan(form.getIsLoan() == 1 ? "是" : "否");
            vo.setAwardsSumNumOfYear(awardNum.toString());
            vo.setHelpsSumNumOfYear(helpNum.toString());
            vo.setReason(form.getReason());
            vo.setIsVery(admitapply.getAdminResult() == 3 ? "是" : "否");
            vo.setDiscountNum(form.getAdminResult().toString());
            list.add(vo);
        }

        ExportExcelUtil.save(response, DiscountFeeVo.lastRow, list, "DiscountFee.xls", "学费减免学生信息汇总表.xls");
    }
}
