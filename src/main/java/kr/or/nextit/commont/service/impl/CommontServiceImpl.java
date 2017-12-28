package kr.or.nextit.commont.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.common.file.mapper.FileItemMapper;
import kr.or.nextit.common.file.model.FileItem;
import kr.or.nextit.commont.mapper.CommontMapper;
import kr.or.nextit.commont.model.Commont;
import kr.or.nextit.commont.service.CommontService;

@Service("commontService")
public class CommontServiceImpl implements CommontService{
	
	@Autowired
	CommontMapper commontMapper;
	
	@Autowired
	FileItemMapper fileItemMapper;
	
	@Override
	public int getCommontCount(Map<String, Object>paramMap) throws Exception {
		return commontMapper.selectCommontCount(paramMap);		
	}
	
	@Override
	public List<Commont> getCommontList(Map<String, Object>paramMap) throws Exception{
		return commontMapper.selectCommontList(paramMap);
	}
	
	@Override
	public Commont getCommont(int comment_num) throws Exception{
		
		commontMapper.updateHitCnt(comment_num);
		
		Commont commont = commontMapper.selectCommont(comment_num);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ref_comment_num", commont.getComment_num());
		paramMap.put("biz_comment_board", commont.getComment_board());
		
		List<FileItem> fileItemList = fileItemMapper.selectFileItemList(paramMap);
		commont.setFileItemList(fileItemList);
		
		return commont;
	}

	@Override
	public int insertCommont(Commont commont) throws Exception{
		
		int updCnt = commontMapper.insertCommont(commont);
		
		List<FileItem> fileItemList = commont.getFileItemList();
		if(fileItemList != null && !fileItemList.isEmpty()) {
			for(FileItem fileItem : fileItemList) {
				fileItem.setRef_comment_num(commont.getComment_num()+"");
				fileItem.setcomment_id(commont.getComment_id());
				fileItem.setcomment_date(commont.getComment_date());
				fileItemMapper.insertFileItem(fileItem);
			}
		}
		return updCnt;
	}
	
	@Override
	public int updatCommont(Commont commont) throws Exception{
		
		String[] delFilecomment_num = commont.getDelFileCommentNum();
		if(delFilecomment_num != null && delFilecomment_num.length > 0) {
			Map<String, Object> paramMap = new HashMap<>();
			fileItemMapper.deleteFileItem(paramMap);
		}
		
		int updCnt = commontMapper.updateCommont(commont);
		
		List<FileItem> fileItemList = commont.getFileItemList();
		if(fileItemList != null && !fileItemList.isEmpty()) {
			for(FileItem fileItem : fileItemList) {
				fileItem.setRef_comment_num(commont.getComment_num()+"");
				fileItem.setcomment_id(commont.getComment_id());
				fileItem.setcomment_date(commont.getComment_date());
				fileItemMapper.insertFileItem(fileItem);
			}
		}

		return updCnt;
	}
	
	@Override
	public int deletCommont(Map<String, Object>paramMap) throws Exception{
		return commontMapper.deleteCommont(paramMap);
	}
}
