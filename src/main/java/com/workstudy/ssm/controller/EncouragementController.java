package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.Encouragement;
import com.workstudy.ssm.model.Prize;
import com.workstudy.ssm.model.User;
import com.workstudy.ssm.service.EncouragementService;
import com.workstudy.ssm.service.PrizeService;
import com.workstudy.ssm.service.UserService;
import com.workstudy.ssm.utils.ExportExcelUtil;
import com.workstudy.ssm.utils.ResponseData;
import com.workstudy.ssm.utils.WordGenerator;
import com.workstudy.ssm.vo.DiscountFeeVo;
import com.workstudy.ssm.vo.EncouragementVo;
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
//国家励志奖学金
@Controller
public class EncouragementController {
    private Logger log = Logger.getLogger(EncouragementController.class);
    private String getCurrentYear () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }

    @Resource
    private EncouragementService encouragementService;
    @Resource
    private PrizeService prizeService;
    @Resource
    private UserService userService;

    @PostMapping("/encouragementtable")
    @ResponseBody
    public Map encouragementtable(@RequestBody Encouragement table) {
        List<Prize> prizes = table.getPrizes();
        prizeService.delPrizeByStId(table.getStudentId());
        log.info(prizes.size());
        for (Prize prize : prizes) {
            if (null != prize) {
                String mMessage = prizeService.createTable(prize);
                log.info("member : " + mMessage);
            }
        }
        String message = encouragementService.createTable(table);
        ResponseData resdata = ResponseData.ok();
        if (!message.equals("申请表登记成功！")) {
            resdata = ResponseData.customerError();
        }
        resdata.putDataValue("result", message);
        return resdata.toMap();
    }

    @PostMapping("/encouragementtablesave")
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

        String identityCardId = (String) map.get("identityCardId");
        map.remove("identityCardId");
        for (int i = 0; i < 18; i++) {
            map.put((char)('a' + i) + "", identityCardId.charAt(i));
        }
//        WordGenerator.save(res, map, "Encouragement", "Encouragement");
//        log.info(map);
        WordGenerator.save(res, map, "Encouragement", "杭州师范大学国家励志奖学金申请审批表");

    }

    @RequestMapping(value = "/encouragementtablesaveExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("通过poi导出encouragement excel文件！");

        //模拟数据库取值
        List<InfoVo> list = new ArrayList<>();
        String year = getCurrentYear();
        String createdYear = year+"-"+String.valueOf(Integer.parseInt(year)+1);
        List<Encouragement> encouragements = encouragementService.getTableByYear(createdYear);
        for (int i = 0; i < encouragements.size(); i++) {
            EncouragementVo vo = new EncouragementVo();
            Encouragement form = encouragements.get(i);
            if (form.getAdminResult() < 1) {
                continue;
            }
            String stId = form.getStudentId();
            User user = userService.getUserInfoById(stId);
            vo.setIndex(Integer.toString(i + 1));
            vo.setName(user.getName());
            vo.setIdentityCardId(form.getIdentityCardId());
            vo.setAcademy(user.getAcademy());
            vo.setMajor(user.getMajor());
            vo.setStudentId(user.getUserId());
            vo.setSex(form.getSex());
            vo.setNation(form.getNation());
            vo.setStartYM(form.getStartYear()+"年"+form.getStartMonth()+"月");
            list.add(vo);
        }

        ExportExcelUtil.save(response, EncouragementVo.lastRow, list, "Encouragement.xls", "励志奖学金获奖学生初审名单表.xls");
    }
}
