package org.CodingWithAlex.controller.system;

import org.CodingWithAlex.bean.Hr;
import org.CodingWithAlex.bean.RespBean;
import org.CodingWithAlex.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
public class SystemHrController {
    @Autowired
    HrService hrService;

    @RequestMapping("/id/{hrId}")
    public Hr getHrById(@PathVariable Long hrId) {
        return hrService.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (hrService.deleteHr(hrId) == 1) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<Hr> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<Hr> hrs = hrService.getHrsByKeywords(keywords);
        return hrs;
    }


    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public RespBean hrReg(String username, String password) {
        int i = hrService.hrReg(username, password);
        if (i == 1) {
            return new RespBean("success", "注册成功!");
        } else if (i == -1) {
            return new RespBean("error", "用户名重复，注册失败!");
        }
        return new RespBean("error", "注册失败!");
    }

}
