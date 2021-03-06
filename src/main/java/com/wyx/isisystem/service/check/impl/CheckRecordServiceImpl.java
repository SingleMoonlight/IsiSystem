package com.wyx.isisystem.service.check.impl;

import com.wyx.isisystem.dao.CheckRecordDao;
import com.wyx.isisystem.dao.ProjectDao;
import com.wyx.isisystem.dao.StaffDao;
import com.wyx.isisystem.entity.CheckRecord;
import com.wyx.isisystem.entity.Project;
import com.wyx.isisystem.service.check.CheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:05
 */
@Service("checkRecordService")
public class CheckRecordServiceImpl implements CheckRecordService {
    @Autowired
    private CheckRecordDao checkRecordDao;



    @Override
    public int addCheckRecord(int staffId, int projectId, int firstLevel, int secondLevel, int riskLevel, String picUrl, String description) {
        CheckRecord checkRecord = new CheckRecord();
        checkRecord.setStaffId(staffId);
        checkRecord.setProjectId(projectId);
        checkRecord.setFirstId(firstLevel);
        checkRecord.setSecondId(secondLevel);
        checkRecord.setRiskLevel(riskLevel);
        checkRecord.setPictureUrl(picUrl);
        checkRecord.setDescription(description);

        return checkRecordDao.insertCheckRecord(checkRecord);
    }

    @Override
    public int getCheckRecordState(int staffId, int projectId) {
        List<CheckRecord> list = checkRecordDao.queryCheckRecordByStaffAndProject(staffId, projectId);
        if (list.size() == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<CheckRecord> getCheckRecordByProject(int projectId) {
        return checkRecordDao.queryCheckRecordByProject(projectId);
    }

    @Override
    public int editCheckRecordState(int checkRecordId, int state) {
        return checkRecordDao.updateCheckRecordState(checkRecordId, state);
    }

}
